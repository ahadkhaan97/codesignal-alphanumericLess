fun main() {
    println(solution2("ab123", "ab34z"))
}

fun solution2(s1: String, s2: String): Boolean {
    val tokens1 = mutableListOf<String>()
    val tokens2 = mutableListOf<String>()
    var token = ""
    for (i in s1.indices) {
        if (s1[i] in '0'..'9') {
            token += s1[i]
            continue
        }
        if (token.isNotEmpty()) {
            tokens1.add(token)
            token = ""
        }
        tokens1.add(s1[i].toString())
    }
    if (token.isNotEmpty()) {
        tokens1.add(token)
        token = ""
    }

    for (i in s2.indices) {
        if (s2[i] in '0'..'9') {
            token += s2[i]
            continue
        }
        if (token.isNotEmpty()) {
            tokens2.add(token)
            token = ""
        }
        tokens2.add(s2[i].toString())
    }
    if (token.isNotEmpty()) {
        tokens2.add(token)
    }


}


fun solution(s1: String, s2: String): Boolean {
    val tokens1 = mutableListOf<String>()
    val tokens2 = mutableListOf<String>()
    var token = ""
    for (i in s1.indices) {
        if (s1[i] in '0'..'9') {
            token += s1[i]
            continue
        }
        if (token.isNotEmpty()) {
            tokens1.add(token)
            token = ""
        }
        tokens1.add(s1[i].toString())
    }
    if (token.isNotEmpty()) {
        tokens1.add(token)
        token = ""
    }

    for (i in s2.indices) {
        if (s2[i] in '0'..'9') {
            token += s2[i]
            continue
        }
        if (token.isNotEmpty()) {
            tokens2.add(token)
            token = ""
        }
        tokens2.add(s2[i].toString())
    }
    if (token.isNotEmpty()) {
        tokens2.add(token)
    }

    if (tokens1.size < tokens2.size) {
        for (i in 0 until tokens1.size) {
            if (!isNumeric(tokens1[i]) && !isNumeric(tokens2[i])
                && tokens1[i].single().code > tokens2[i].single().code
            ) {
                return false
            }

            if (isNumeric(tokens1[i]) && isNumeric(tokens2[i]) && tokens1[i].toInt() > tokens2[i].toInt()) {
                return true
            }
        }
        return true
    }
    if (tokens1.size > tokens2.size)
        return false

    for (i in 0 until tokens1.size) {
        if (isNumeric(tokens1[i]) && isNumeric(tokens2[i]) && tokens1[i].toInt() < tokens2[i].toInt()) {
            return true
        } else if (isNumeric(tokens1[i]) && !isNumeric(tokens2[i])) {
            return true
        } else if (!isNumeric(tokens1[i]) && !isNumeric(tokens2[i])
            && tokens1[i].single().code < tokens2[i].single().code
        ) {
            return true
        }
    }

    return false
}

fun isNumeric(str: String): Boolean {
    return str.toDoubleOrNull() != null
}
