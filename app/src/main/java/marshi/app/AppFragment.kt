package marshi.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.androidtemplate.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AppFragment : DaggerFragment() {

    companion object {
        fun newInstance() = AppFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<AppViewModel>
    private val viewModel: AppViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.app_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.plus(1, 2)
    }

}
