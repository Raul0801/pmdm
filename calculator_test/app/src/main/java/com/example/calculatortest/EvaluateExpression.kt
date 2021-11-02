package com.example.calculatortest

import java.util.*
// Source: https://www.geeksforgeeks.org/expression-evaluation/
//TODO Create my own evaluate expression method
//TODO Add decimals to evaluateExpression so users can operate with decimals

fun evaluateGeeksForGeeks(expression: String): Double {
        val tokens = expression.toCharArray()

        // Stack for numbers: 'values'
        val values: Stack<Double> = Stack<Double>()

        // Stack for Operators: 'ops'
        val ops: Stack<Char> = Stack<Char>()
        var i = 0
        while (i < tokens.size) {


            // Current token is a
            // whitespace, skip it
            if (tokens[i] == ' ') {
                i++
                continue
            }

            // Current token is a number,
            // push it to stack for numbers
            if (tokens[i] >= '0' &&
                tokens[i] <= '9'
            ) {
                val sbuf = StringBuffer()

                // There may be more than one
                // digits in number
                while (i < tokens.size && tokens[i] >= '0' && tokens[i] <= '9') sbuf.append(tokens[i++])
                values.push(sbuf.toString().toDouble())

                // right now the i points to
                // the character next to the digit,
                // since the for loop also increases
                // the i, we would skip one
                //  token position; we need to
                // decrease the value of i by 1 to
                // correct the offset.
                i--

            // Current token is an opening brace,
            // push it to 'ops'
            } else if (tokens[i] == '(') ops.push(tokens[i])

            // Closing brace encountered,
            // solve entire brace
            else if (tokens[i] == ')') {
                while (ops.peek() !== '(') values.push(
                    applyOp(
                        ops.pop(),
                        values.pop(),
                        values.pop()
                    )
                )
                ops.pop()
                // Current token is an operator.
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                // While top of 'ops' has same
                // or greater precedence to current
                // token, which is an operator.
                // Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() &&
                    hasPrecedence(
                        tokens[i],
                        ops.peek()
                    )
                ) values.push(
                    applyOp(
                        ops.pop(),
                        values.pop(),
                        values.pop()
                    )
                )

                // Push current token to 'ops'.
                ops.push(tokens[i])
            }
            i++
        }

        // Entire expression has been
        // parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty()) values.push(
            applyOp(
                ops.pop(),
                values.pop(),
                values.pop()
            )
        )

        // Top of 'values' contains
        // result, return it
        return values.pop()
    }

    // Returns true if 'op2' has higher
    // or same precedence as 'op1',
    // otherwise returns false.
    fun hasPrecedence(
        op1: Char, op2: Char
    ): Boolean {
        if (op2 == '(' || op2 == ')') return false
        return if ((op1 == '*' || op1 == '/') &&
            (op2 == '+' || op2 == '-')
        ) false else true
    }

    // A utility method to apply an
    // operator 'op' on operands 'a'
    // and 'b'. Return the result.
    fun applyOp(
        op: Char,
        b: Double, a: Double
    ): Double {
        when (op) {
            '+' -> return (a + b)
            '-' -> return (a - b)
            '*' -> return (a * b)
            '/' -> {
                if (b == 0.0) (
                    return 0.0
                )
                return (a / b)
            }
        }
        return 0.0
    }