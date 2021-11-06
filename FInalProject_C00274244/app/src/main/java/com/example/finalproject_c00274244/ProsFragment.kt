package com.example.finalproject_c00274244

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.finalproject_c00274244.ui.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_pros.*
import kotlinx.android.synthetic.main.main_fragment.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var user : String
    private lateinit var game : String
    private lateinit var rating : String
    private lateinit var viewModel: MainViewModel
    override fun onStart(){
        super.onStart()
        arguments?.let{
            var args = ProsFragmentArgs.fromBundle(it)
            user = args.username
            game = args.game
            rating = args.rating
            psSubmit.setOnClickListener{
                try{
                    if(pros.text.toString().length > 150) confirmation.setText("Whoa, we didn't ask for a novel! Please try to be more concise and shorten your response.")
                    else if(cons.text.toString().length > 150) confirmation.setText("Whoa, we didn't ask for a novel! Please try to be more concise and shorten your response.")
                    else{
                        var pro = pros.text.toString()
                        var con = cons.text.toString()
                        if(pros.text.toString() == "") pro = "Not Specified."
                        if(cons.text.toString() == "") con = "Not Specified."
                        val anEntry = Entry(0, user, game, rating.toDouble(), pro, con)
                        viewModel.insertEntry(anEntry)
                        confirmation.setText("Success! Thank you for your feedback for this game! You may now go back to the previous screen.")
                    }
                     }catch(e: Exception){
                    confirmation.setText("Whoops! We couldn't add your entry! Some kind of error occured!")
                }

            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pros, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}