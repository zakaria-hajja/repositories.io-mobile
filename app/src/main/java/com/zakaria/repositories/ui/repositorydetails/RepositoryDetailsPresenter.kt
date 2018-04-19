package com.zakaria.repositories.ui.repositorydetails;
import android.databinding.ObservableField
import com.zakaria.repositories.data.DataManager
import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.data.model.RepositoryDTO
import com.zakaria.repositories.utils.JoinDate
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


class RepositoryDetailsPresenter {

     lateinit var repository:Repository
     var created_at:ObservableField<String>
     var updated_at:ObservableField<String>
     var language:ObservableField<String>
     var visibleLanguage:ObservableField<Boolean>


     lateinit var viewModel : RepositoryDetailsViewModel
     var dataManager: DataManager

     @Inject
     constructor(dataManager: DataManager){
          this.dataManager=dataManager
          this.created_at =ObservableField()
          this.updated_at =ObservableField()
          this.language = ObservableField()
          this.visibleLanguage = ObservableField(false)


     }

     fun getRepository(owner:String,repository: String): Single<RepositoryDTO> {
          viewModel.dataManager = this.dataManager
          return viewModel.getRepository(owner,repository)
     }

     fun toRepository(repository: RepositoryDTO){
          created_at.set("created at : ${JoinDate(repository.created)}")
          updated_at.set("updated at : ${JoinDate(repository.updated)}")
          if(repository!=null){
               language.set(repository.language.toUpperCase())
               visibleLanguage.set(true)
          }
     }


}
