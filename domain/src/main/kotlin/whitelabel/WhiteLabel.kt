package whitelabel

import AggregatorRoot
import validation.ValidationHandler
import whitelabel.module.Color
import whitelabel.module.Logo
import whitelabel.module.Theme
import java.time.Instant

class WhiteLabel private constructor(
    val anId: WhiteLabelID,
    val aPartner: String,
    val theme: Theme,
    val createdAt: Instant = Instant.now(),
    var updatedAt: Instant = Instant.now(),
    var deletedAt: Instant? = null,
) : AggregatorRoot<WhiteLabelID>(anId) {
    companion object {
        fun newWhiteLabel(
            partner: String,
            primaryColor: Color,
            secondaryColor: Color,
            progressColor: Color,
            splashScreenIcon: Logo,
            coloredLogo: Logo,
            whiteLogo: Logo,
            blackLogo: Logo,
            animatedContent: String
        ) : WhiteLabel {
            val theme = Theme(
                aPrimaryColor = primaryColor,
                aSecondaryColor = secondaryColor,
                aProgressColor = progressColor,
                aSplashScreenIcon = splashScreenIcon,
                aColoredLogo = coloredLogo,
                aWhiteLogo = whiteLogo,
                aBlackLogo = blackLogo,
                aAnimatedContent = animatedContent
            )

            val whitelabel = WhiteLabel(
                anId = WhiteLabelID.unique(),
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