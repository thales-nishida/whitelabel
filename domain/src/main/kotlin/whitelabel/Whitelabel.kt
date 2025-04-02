package whitelabel

import AggregatorRoot
import validation.ValidationHandler
import whitelabel.module.Color
import whitelabel.module.Base64
import whitelabel.module.Theme
import java.time.Instant

class Whitelabel private constructor(
    val anId: WhitelabelID,
    val aPartner: String,
    val theme: Theme,
    val createdAt: Instant = Instant.now(),
    var updatedAt: Instant = Instant.now(),
    var deletedAt: Instant? = null,
) : AggregatorRoot<WhitelabelID>(anId) {
    companion object {
        fun newWhiteLabel(
            partner: String,
            primaryColor: Color,
            secondaryColor: Color,
            progressColor: Color,
            splashScreenIcon: Base64,
            coloredBase64: Base64,
            whiteBase64: Base64,
            blackBase64: Base64,
            animatedContent: Base64
        ) : Whitelabel {
            val theme = Theme(
                aPrimaryColor = primaryColor,
                aSecondaryColor = secondaryColor,
                aProgressColor = progressColor,
                aSplashScreenIcon = splashScreenIcon,
                aColoredBase64 = coloredBase64,
                aWhiteBase64 = whiteBase64,
                aBlackBase64 = blackBase64,
                aAnimatedContent = animatedContent
            )

            val whitelabel = Whitelabel(
                anId = WhitelabelID.unique(),
                aPartner = partner,
                theme = theme,
            )

            return whitelabel
        }
    }

    override fun validate(handler: ValidationHandler) {
        WhiteLabelValidator(this, handler).validate()
    }
}