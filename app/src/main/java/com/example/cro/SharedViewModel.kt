package com.example.cro

    import androidx.lifecycle.LiveData
    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel

    class SharedViewModel : ViewModel() {
        private val tasksLiveData = MutableLiveData<List<Task>>(listOf(
            Task(
                1,
                "Ejercicio en casa",
                "Salud",
                "1 hora",
                "https://images.vexels.com/media/users/3/136168/isolated/preview/870245359fd482ecc414477b878b8f16-logotipo-de-salud.png",
                "https://pic.pikbest.com/02/23/99/786888piChnZ.jpg!bw700"
            ),
            Task(
                2,
                "Jornada laboral",
                "Ocupacion",
                "8 horas",
                "https://cdn-icons-png.flaticon.com/512/4149/4149648.png",
                "https://media.istockphoto.com/id/1355248804/es/vector/tiempo-para-tomar-un-descanso-tiempo-de-pausa-para-el-caf%C3%A9-para-relajarse-y-refrescarse-del.jpg?s=612x612&w=0&k=20&c=g1pGxcsQg6OhFDxNaKYgbyu-rRgsaXtAlJC70a5ordk="
            ),
            Task(
                3,
                "Carnita asada",
                "Comida",
                "2 horas",
                "https://cdn-3.expansion.mx/dims4/default/3cb5b66/2147483647/resize/1280x/quality/90/?url=https%3A%2F%2Fcdn-3.expansion.mx%2Fa1%2Fee%2F5f93865746ac9c0a7457600b51e8%2Fbrasas-mexico-2022-festival-carne-asada-parrillas.jpg",
                "res/drawable/conviv.png"
            ),
            Task(
                4,
                "Carnita asada",
                "Comida",
                "2 horas",
                "win url",
                "image url"
            )
            ,
            Task(
                5,
                "Carnita asada",
                "Comida",
                "2 horas",
                "win url",
                "image url"
            )
            ,
            Task(
                6,
                "Carnita asada",
                "Comida",
                "2 horas",
                "win url",
                "image url"
            )
            ,
            Task(
                7,
                "Carnita asada",
                "Comida",
                "2 horas",
                "win url",
                "image url"
            )
            ,
            Task(
                8,
                "Carnita asada",
                "Comida",
                "2 horas",
                "win url",
                "image url"
            ),
            Task(
                9,
                "Carnita asada",
                "Comida",
                "2 horas",
                "win url",
                "image url"
            ),
            Task(
                10,
                "Carnita asada",
                "Comida",
                "2 horas",
                "win url",
                "image url"
            )

        ))

        fun getTasks(): LiveData<List<Task>> = tasksLiveData

        fun addTask(newTask: Task) {
            tasksLiveData.value = tasksLiveData.value?.plus(newTask)
        }

    }
