package marshi.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.androidtemplate.R
import com.example.androidtemplate.databinding.AppFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AppFragment : DaggerFragment() {

  companion object {
    fun newInstance() = AppFragment()
  }

  @Inject
  lateinit var viewModelFactory: ViewModelFactory<AppViewModel>
  private val viewModel: AppViewModel by viewModels { viewModelFactory }
  private lateinit var binding: AppFragmentBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding =
      DataBindingUtil.inflate<AppFragmentBinding>(inflater, R.layout.app_fragment, container, false)


    binding.button.setOnClickListener {
      val sheet = BottomSheetBehavior.from(binding.layout)
      sheet.state = BottomSheetBehavior.STATE_EXPANDED
    }

    return binding.root
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel.plus(1, 2)
  }

}
