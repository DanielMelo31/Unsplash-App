package com.example.imagesearchapp.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.imagesearchapp.domain.Repository

class GalleryViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {
}