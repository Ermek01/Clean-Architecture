package kg.smartpost.cleanarchitecture.data.network.students.model

class ModelStudents : ArrayList<ModelStudents.ModelStudentsItem>(){
    data class ModelStudentsItem(
        val actor: String,
        val alive: Boolean,
        val alternate_actors: List<Any>,
        val alternate_names: List<Any>,
        val ancestry: String,
        val dateOfBirth: String,
        val eyeColour: String,
        val gender: String,
        val hairColour: String,
        val hogwartsStaff: Boolean,
        val hogwartsStudent: Boolean,
        val house: String,
        val image: String,
        val name: String,
        val patronus: String,
        val species: String,
        val wand: Wand,
        val wizard: Boolean,
        val yearOfBirth: String
    ) {
        data class Wand(
            val core: String,
            val length: String,
            val wood: String
        )
    }
}