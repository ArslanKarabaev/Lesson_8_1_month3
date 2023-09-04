package com.example.lesson_8_1_month3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_8_1_month3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var rvCharacters: RecyclerView
    private val  list= arrayListOf(
        CharacterModel("Rick Sanchez", "Alive", "https://static.tildacdn.com/stor6539-3436-4630-b561-383037633561/50153018.jpg"),
        CharacterModel("Morty Smith", "Alive", "https://i.pinimg.com/originals/57/01/2a/57012abb682000eef51c6506023c6ff8.jpg"),
        CharacterModel("Albert Einstein", "Died", "https://pbs.twimg.com/profile_images/1455589658667192326/iEwqB8dO.jpg"),
        CharacterModel("Jerry Smith", "Alive", "https://m.media-amazon.com/images/S/aplus-media/sc/6da81033-3410-447a-998f-ca74a46631b4.__CR0,0,300,300_PT0_SX300_V1___.png")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCharacters = view.findViewById(R.id.rv_characters)
        val adapter = CharacterAdapter(list, this::onClick)
        rvCharacters.adapter = adapter


    }

    private fun onClick(position: Int){
        findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(list[position].name.toString(), list[position].status.toString(), list[position].photo.toString()))

    }
}