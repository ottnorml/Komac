package data.shared

import commands.interfaces.TextPrompt
import commands.interfaces.ValidationRules
import data.ManifestData
import data.PreviousManifestData

object PackageName : TextPrompt {
    override val name: String = "Package name"

    override val validationRules: ValidationRules = ValidationRules(
        maxLength = 256,
        minLength = 2,
        isRequired = true
    )

    override val extraText: String = buildString {
        append("Example: Microsoft Teams")
        ManifestData.msi?.productName?.let { appendLine("Detected from MSI: $it") }
    }

    override val default: String? get() = PreviousManifestData.defaultLocaleManifest?.packageName
}
