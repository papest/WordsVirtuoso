fun doubleFormat(value: Double, width: Int, precision: Int): String = String.format("%$width.${precision}f", value)
