fun solution(newSet: MutableSet<String>, oldSet: Set<String>): MutableSet<String> {
    newSet.addAll(oldSet.filter { it.startsWith("a", true) })
    return newSet
}