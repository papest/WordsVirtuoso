fun names(namesList: List<String>): List<String> {
    val nameCount = mutableListOf<String>()
    namesList.toSet().forEach { i -> nameCount.add("The name $i is repeated ${namesList.count { it == i }} times") }
    return nameCount
}