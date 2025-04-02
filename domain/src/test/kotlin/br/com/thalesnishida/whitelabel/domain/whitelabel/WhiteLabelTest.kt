package br.com.thalesnishida.whitelabel.domain.whitelabel

import exceptions.DomainException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import validation.handler.ThrowsValidationHandler
import whitelabel.WhiteLabel
import whitelabel.module.Color
import whitelabel.module.Logo

class WhiteLabelTest {

    @Test
    fun givenAValidParams_whenCallWhitelabel_thenShouldInstanceWhitelabel() {
        val expectPartner = "Test"
        val expectPrimaryColor = Color("#FFFFFF")
        val expectSecondaryColor = Color("#FFFFFF")
        val expectProgressColor = Color("#FFFFFF")
        val expectSplashScreenIcon = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectColoredLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectWhiteLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectBlackLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectAnimatedContent = """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()

        val actualWhiteLabel = WhiteLabel.newWhiteLabel(
            expectPartner,
            expectPrimaryColor,
            expectSecondaryColor,
            expectProgressColor,
            expectSplashScreenIcon,
            expectColoredLogo,
            expectWhiteLogo,
            expectBlackLogo,
            expectAnimatedContent
        )

        Assertions.assertNotNull(actualWhiteLabel)
        Assertions.assertNotNull(actualWhiteLabel.anId)
        Assertions.assertEquals(expectPartner, actualWhiteLabel.aPartner)
        Assertions.assertEquals(expectPrimaryColor, actualWhiteLabel.theme.aPrimaryColor)
        Assertions.assertEquals(expectSecondaryColor, actualWhiteLabel.theme.aSecondaryColor)
        Assertions.assertEquals(expectProgressColor, actualWhiteLabel.theme.aProgressColor)
        Assertions.assertEquals(expectSplashScreenIcon, actualWhiteLabel.theme.aSplashScreenIcon)
        Assertions.assertEquals(expectColoredLogo, actualWhiteLabel.theme.aColoredLogo)
        Assertions.assertEquals(expectWhiteLogo, actualWhiteLabel.theme.aWhiteLogo)
        Assertions.assertEquals(expectBlackLogo, actualWhiteLabel.theme.aBlackLogo)
        Assertions.assertEquals(expectAnimatedContent, actualWhiteLabel.theme.aAnimatedContent)
    }

    @Test
    fun givenAInvalidLogo_whenCallWhitelabel_thenShouldReturnDomainError() {
        val expectPartner = "Test"
        val expectPrimaryColor = Color("#FFFFFF")
        val expectSecondaryColor = Color("#FFFFFF")
        val expectProgressColor = Color("#FFFFFF")
        val expectSplashScreenIcon = Logo("", )
        val expectColoredLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectWhiteLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectBlackLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectAnimatedContent = """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()

        val expectErrorMessage = "[Logo 'SplashScreenIcon' cannot be blank]"

        val actualWhiteLabel = WhiteLabel.newWhiteLabel(
            expectPartner,
            expectPrimaryColor,
            expectSecondaryColor,
            expectProgressColor,
            expectSplashScreenIcon,
            expectColoredLogo,
            expectWhiteLogo,
            expectBlackLogo,
            expectAnimatedContent
        )

        val actualException =
            Assertions.assertThrows(DomainException::class.java) { actualWhiteLabel.validate(ThrowsValidationHandler()) }

        Assertions.assertEquals(expectErrorMessage, actualException.message)
    }

    @Test
    fun givenAInvalidPrimaryColor_whenCallWhitelabel_thenShouldReturnDomainError() {
        val expectPartner = "Test"
        val expectPrimaryColor = Color("FF")
        val expectSecondaryColor = Color("#FFFFFF")
        val expectProgressColor = Color("#FFFFFF")
        val expectSplashScreenIcon = Logo("""
            VBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukv
        """.trimIndent(), )
        val expectColoredLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectWhiteLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectBlackLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectAnimatedContent = """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()

        val expectErrorMessage = "'primaryColor' must be a valid HEX format (#RRGGBB or #RGB)"

        val actualWhiteLabel = WhiteLabel.newWhiteLabel(
            expectPartner,
            expectPrimaryColor,
            expectSecondaryColor,
            expectProgressColor,
            expectSplashScreenIcon,
            expectColoredLogo,
            expectWhiteLogo,
            expectBlackLogo,
            expectAnimatedContent
        )

        val actualException =
            Assertions.assertThrows(DomainException::class.java) { actualWhiteLabel.validate(ThrowsValidationHandler()) }

        Assertions.assertEquals(expectErrorMessage, actualException.getErrors()[0].message)
    }

    @Test
    fun givenAInvalidColor_whenCallWhitelabel_thenShouldReturnDomainError() {
        val expectPartner = "Test"
        val expectPrimaryColor = Color("#4338CA")
        val expectSecondaryColor = Color("FFF")
        val expectProgressColor = Color("#FFFFFF")
        val expectSplashScreenIcon = Logo("""
            VBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukv
        """.trimIndent(), )
        val expectColoredLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectWhiteLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectBlackLogo = Logo(
            """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()
        )
        val expectAnimatedContent = """
            iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAvd0lEQVR42u3dC3RddZ3o8f8+SZ95NCmP22r
            LpIhaQLA8hMLgzO6IPGTJa8QFik5RZwnDdW6aoJDUZcOsNTzWmgusmYswMzjFe0FUWMDAIEUaGhEBvQzt1AutiDYDFTqF9o
            RWsa1N9t3/E8o/lDb5nXP2Pv/H+X7WqidCzukvITnne/bjvyMFWNQZF9salVowrJL5kYpmjflXM6L0n9ueT5scRemMUXMU
            qcZJqtBmex7UxI7053GH/iD97z6kbwtKbUtvRmwPJhJF60fUyH+pkWhw0oha8bWB5k22R4J7ItsDoH5cERfj9NkzTp9YP6hUM
        """.trimIndent()

        val expectErrorMessage = "'secondaryColor' must be a valid HEX format (#RRGGBB or #RGB)"

        val actualWhiteLabel = WhiteLabel.newWhiteLabel(
            expectPartner,
            expectPrimaryColor,
            expectSecondaryColor,
            expectProgressColor,
            expectSplashScreenIcon,
            expectColoredLogo,
            expectWhiteLogo,
            expectBlackLogo,
            expectAnimatedContent
        )

        val actualException =
            Assertions.assertThrows(DomainException::class.java) { actualWhiteLabel.validate(ThrowsValidationHandler()) }

        Assertions.assertEquals(expectErrorMessage, actualException.getErrors()[0].message)
    }
}