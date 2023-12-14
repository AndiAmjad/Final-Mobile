import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.d121211064.mycat.data.model.CatImage
import com.d121211064.mycat.data.repository.CatRepository
import kotlinx.coroutines.launch

class MainViewModel(private val catRepository: CatRepository) : ViewModel() {

    private val _catImages = MutableLiveData<List<CatImage>>()
    val catImages: LiveData<List<CatImage>> get() = _catImages

    private val _selectedImage = MutableLiveData<String>()
    val selectedImage: LiveData<String> get() = _selectedImage

    init {
        // Misalnya, secara default, pilih gambar pertama saat ViewModel diinisialisasi
        _selectedImage.value = ""
    }

    fun loadCatImages() {
        viewModelScope.launch {
            val images = catRepository.getCatImages()
            _catImages.value = images
            // Misalnya, secara default, pilih gambar pertama
            _selectedImage.value = images.firstOrNull()?.url
        }
    }

    fun selectImage(imageUrl: String) {
        _selectedImage.value = imageUrl
    }
}
