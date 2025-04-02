package whitelabel

import validation.ValidationHandler
import validation.Validator
import validation.handler.Notification
import whitelabel.enuns.ColorField
import whitelabel.enuns.LogoField
import whitelabel.module.Color
import whitelabel.module.Base64

class WhiteLabelValidator(
    private val whiteLabel: WhiteLabel,
    private val anHandler: ValidationHandler
) : Validator(anHandler) {

    override fun validate() {
        validateLogo(this.whiteLabel.theme.aSplashScreenIcon.logo, LogoField.SPLASH_SCREEN_ICON)
        validateLogo(this.whiteLabel.theme.aColoredBase64.logo, LogoField.COLORED_LOGO)
        validateLogo(this.whiteLabel.theme.aWhiteBase64.logo, LogoField.WHITE_LOGO)
        validateLogo(this.whiteLabel.theme.aBlackBase64.logo, LogoField.BLACK_LOGO)
        validateColor(this.whiteLabel.theme.aPrimaryColor.hex, fieldName = ColorField.PRIMARY_COLOR)
        validateColor(this.whiteLabel.theme.aSecondaryColor.hex, ColorField.SECONDARY_COLOR)
    }

    private fun validateLogo(logo: String, fieldName: LogoField = LogoField.LOGO) {
        val notification = Notification.create()
        Base64.create(logo = logo, fieldName = fieldName, handler = notification)
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