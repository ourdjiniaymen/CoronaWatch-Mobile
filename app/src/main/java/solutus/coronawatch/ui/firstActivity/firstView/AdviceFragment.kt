package solutus.coronawatch.ui.firstActivity.firstView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.coronawatch_mobile.R
import kotlinx.android.synthetic.main.advice_fragment.*

class AdviceFragment : Fragment() {

    companion object {
        fun newInstance() = AdviceFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.advice_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        empty_w_cercle.setOnClickListener {
            val navController: NavController =
                Navigation.findNavController(activity!!, R.id.first_fragment)
            navController.navigate(R.id.to_start_fragment_action)
        }
    }

}
