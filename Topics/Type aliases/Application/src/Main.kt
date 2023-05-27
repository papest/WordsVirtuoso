typealias johnArea = John.JohnApartment
typealias nickArea = Nick.NickApartment

class John {
    data class JohnApartment(val size: Int)
}

class Nick {
    data class NickApartment(val size: Int)
}

@Suppress("All")
fun findTotalArea() = johnArea(40).size + nickArea(60).size
