package com.bignerdranch.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_character.*

private const val CHARACTER_DATA_KEY = "CHARACTER_DATA_KEY"
private var Bundle.characterData
    get() = getSerializable(CHARACTER_DATA_KEY) as CharacterGenerator.CharacterData
    set(value) = putSerializable(CHARACTER_DATA_KEY, value)
class NewCharacterActivity : AppCompatActivity() {
    private var characterData = CharacterGenerator.generate()

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.characterData = characterData
        /*Увага! outState*/
        /*outState.putSerializable(CHARACTER_DATA_KEY, characterData)*/
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_character)
        /*
        *
        *
        *
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val raceTextView = findViewById<TextView>(R.id.raceTextView)
        val dexterityTextView = findViewById<TextView>(R.id.dexterityTextView)
        val wisdomTextView = findViewById<TextView>(R.id.wisdomTextView)
        val strengthTextView = findViewById<TextView>(R.id.strengthTextView)
        val generateButton = findViewById<Button>(R.id.generateButton)
        characterData.run {
            nameTextView.text = name
            raceTextView.text=race
            dexterityTextView.text=dex
            wisdomTextView.text=wis
            strengthTextView.text=str
        }
        */

        /*characterData = savedInstanceState?.let {
            it.getSerializable(CHARACTER_DATA_KEY)
                    as CharacterGenerator.CharacterData
        } ?: CharacterGenerator.generate()*/
        characterData=savedInstanceState?.characterData ?:
            CharacterGenerator.generate()

        generateButton.setOnClickListener {
            characterData=CharacterGenerator.generate()
            displayCharacterData()
        }

        displayCharacterData()
    }

    private fun displayCharacterData(){
        characterData.run {
            nameTextView.text = name
            raceTextView.text=race
            dexterityTextView.text=dex
            wisdomTextView.text=wis
            strengthTextView.text=str
        }
    }
}
