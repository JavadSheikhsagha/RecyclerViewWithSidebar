package ir.nikapps.recyclerviewsnappedtoside

object DataStore {

    fun provideDataForSidebar() : List<String>{
        return listOf(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
        )
    }

    fun provideDataForMainRv() : List<MainItemModel> {
        return listOf(
            MainItemModel(1,"hello"),
            MainItemModel(1,"hello2"),
            MainItemModel(1,"hello3"),
            MainItemModel(2,"peach"),
            MainItemModel(2,"hello"),
            MainItemModel(2,"cabbage"),
            MainItemModel(2,"tomato"),
            MainItemModel(3,"pend"),
            MainItemModel(3,"climb"),
            MainItemModel(3,"hand"),
            MainItemModel(3,"head"),
            MainItemModel(3,"einpaar"),
            MainItemModel(5,"katze"),
            MainItemModel(5,"hunde"),
            MainItemModel(5,"auto"),
            MainItemModel(5,"morgen"),
            MainItemModel(6,"iran"),
            MainItemModel(6,"usa"),
            MainItemModel(6,"uk"),
            MainItemModel(6,"india"),
            MainItemModel(7,"table"),
            MainItemModel(7,"keyboard"),
            MainItemModel(7,"monitor"),
            MainItemModel(7,"mouse"),
            MainItemModel(8,"food"),
            MainItemModel(8,"water"),
            MainItemModel(9,"europe"),
            MainItemModel(9,"asia"),
            MainItemModel(9,"africa"),
            MainItemModel(10,"END"),
        )
    }
}