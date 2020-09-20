query{
    AllProcessModel {
      ...processInfo
  }
  AllTaskModel {
      ...tasksInfo
  }
}



fragment processInfo on ProcessModel {
  processList{
           id
           tenantName
           processInstanceId
           tasks{
             id
           tenantName
           processInstanceId
           }
       },
                                     _pageInfo{
                                        number
                                        numberOfElements
                                        totalElements
                                        totalPages
       }
}

fragment tasksInfo on TaskModel {

  taskList{
           id
           tenantName
           processInstanceId
           processes{
               id
           }
       },
                                     _pageInfo{
                                        number
                                        numberOfElements
                                        totalElements
                                        totalPages
       }

}
