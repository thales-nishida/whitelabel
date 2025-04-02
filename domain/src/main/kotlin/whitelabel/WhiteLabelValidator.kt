package whitelabel

import validation.ValidationHandler
import validation.Validator
import validation.handler.Notification
import whitelabel.enuns.ColorField
import whitelabel.enuns.LogoField
import whitelabel.module.Color
import whitelabel.module.Logo

class WhiteLabelValidator(
    private val whiteLabel: WhiteLabel,
    private val anHandler: ValidationHandler
) : Validator(anHandler) {

    override fun validate() {
        validateLogo(whiteLabel.theme.aColoredLogo.logo)
        validateLogo(whiteLabel.theme.aBlackLogo.logo,)
        validateLogo(whiteLabel.theme.aWhiteLogo.logo)
        validateLogo(whiteLabel.theme.aSplashScreenIcon.logo)
        validateColor(this.whiteLabel.theme.aPrimaryColor.hex, fieldName = ColorField.PRIMARY_COLOR)
        validateColor(this.whiteLabel.theme.aSecondaryColor.hex, ColorField.SECONDARY_COLOR)
    }

    private fun validateLogo(logo: String) {
        val notification = Notification.create()
        Logo.create(logo = logo, fieldName = LogoField.SPLASH_SCREEN_ICON, handler = notification)
        if (notification.hasErrors()) {
            anHandler.append(notification)
        }
    }

    private fun validateColor(hex: String, fieldName: ColorField = ColorField.COLOR) {
        val notification = Notification.create()
        Color.create(hex = hex, handler = notification, field = fieldName)
        if (notification.hasErrors()) {
            anHandler.append(notification)
        }
    }
}