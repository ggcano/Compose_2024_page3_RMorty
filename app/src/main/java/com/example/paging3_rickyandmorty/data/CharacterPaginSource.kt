package com.example.paging3_rickyandmorty.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3_rickyandmorty.di.RickMortyApiService
import java.io.IOException
import javax.inject.Inject

class CharacterPagingSource @Inject constructor(private val api: RickMortyApiService) :
    PagingSource<Int, CharacterModel>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {

        return try {
            val page = params.key ?: 1
            val response = api.getCharacters(page)
            val characters = response.results

            val prevKey = if (page > 0) page - 1 else null
            val nextKey = page + 1

            LoadResult.Page(
                data = characters.map { it.toPresentation() },
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        }

    }
}
