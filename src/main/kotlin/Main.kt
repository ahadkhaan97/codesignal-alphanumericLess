fun main() {
    println(solution("ab123", "ab34z"))
}

fun solution(s1: String, s2: String): Boolean {
    val s1Tokens = tokenize(s1)
    val s2Tokens = tokenize(s2)
    var lastZero: Int? = null
    for (i in s1Tokens.indices) {
        if (i >= s2Tokens.size) return false
        val t1 = s1Tokens[i]
        val t2 = s2Tokens[i]
        if (t1[0] in '0'..'9') {
            if (t2[0] in '0'..'9') {
                if (t1.toBigInteger() > t2.toBigInteger()) {
                    return false
                } else if (t2.toBigInteger() > t1.toBigInteger()) {
                    return true
                } else if (t1.length != t2.length && lastZero == null) {
                    lastZero = t1.length - t2.length
                }
            } else {
                return true
            }
        } else {
            if (t1 > t2) {
                return false
            } else if (t2 > t1) {
                return true
            }
        }
    }
    if (s1Tokens.size < s2Tokens.size) return true
    if (lastZero != null && lastZero > 0) return true
    return false
}

fun tokenize(s: String): List<String> {
    var i = 0
    val tokens = mutableListOf<String>()
    while (i < s.length) {
        if (s[i] in '0'..'9') {
            var token = ""
            while (i < s.length && s[i] in '0'..'9') {
                token += s[i++]
            }
            tokens.add(token)
        } else {
            tokens.add(s[i++].toString())
        }
    }
    return tokens
}

