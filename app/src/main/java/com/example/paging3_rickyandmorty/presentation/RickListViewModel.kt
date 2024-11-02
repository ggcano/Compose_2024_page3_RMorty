package com.example.paging3_rickyandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.paging3_rickyandmorty.data.CharacterModel
import com.example.paging3_rickyandmorty.data.RickRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RickListViewModel @Inject constructor(rickRepository: RickRepository) : ViewModel() {

    val characters: Flow<PagingData<CharacterModel>> = rickRepository.getAllCharacters()
}