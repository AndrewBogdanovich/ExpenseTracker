package com.example.expensetracker

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Phone",
    group = "Devices",
    showSystemUi = true,
    device = Devices.PIXEL
)
annotation class PhonePreview

@Preview(
    name = "Tablet",
    group = "Devices",
    showSystemUi = true,
    device = Devices.TABLET
)
annotation class TabletPreview

@PhonePreview
annotation class DevicesPreview