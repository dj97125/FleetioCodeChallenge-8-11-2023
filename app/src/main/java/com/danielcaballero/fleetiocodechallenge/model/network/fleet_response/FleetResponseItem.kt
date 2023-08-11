package com.danielcaballero.fleetiocodechallenge.model.network.fleet_response

data class FleetResponseItem(
    val account_id: Int?,
    val ai_enabled: Boolean?,
    val archived_at: Any?,
    val assetable_type: String?,
    val color: String?,
    val comments_count: Int?,
    val created_at: String?,
    val current_location_entry: CurrentLocationEntry?,
    val current_location_entry_id: Int?,
    val current_meter_date: String?,
    val current_meter_value: Int?,
    val custom_fields: CustomFields?,
    val default_image_url: String?,
    val default_image_url_large: String?,
    val default_image_url_medium: String?,
    val default_image_url_small: String?,
    val documents_count: Int?,
    val driver: Driver?,
    val estimated_replacement_mileage: Int?,
    val estimated_resale_price: EstimatedResalePrice?,
    val estimated_service_months: Int?,
    val external_ids: ExternalIds?,
    val fuel_entries_count: Int?,
    val fuel_type_id: Int?,
    val fuel_type_name: String?,
    val fuel_volume_units: String?,
    val group_ancestry: String?,
    val group_id: Int?,
    val group_name: String?,
    val id: Int?,
    val images_count: Int?,
    val in_service_date: String?,
    val in_service_meter: Int?,
    val inspection_schedules_count: Int?,
    val is_sample: Boolean?,
    val issues_count: Int?,
    val license_plate: String?,
    val loan_account_number: String?,
    val loan_amount: Double?,
    val loan_ended_at: String?,
    val loan_interest_rate: Double?,
    val loan_notes: String?,
    val loan_payment: Double?,
    val loan_started_at: String?,
    val loan_vendor_id: Int?,
    val loan_vendor_name: String?,
    val make: String?,
    val meter_name: String?,
    val meter_unit: String?,
    val model: String?,
    val name: String?,
    val out_of_service_date: String?,
    val out_of_service_meter: Int?,
    val ownership: String?,
    val primary_meter_usage_per_day: String?,
    val registration_expiration_month: Int?,
    val registration_state: String?,
    val residual_value: Int?,
    val secondary_meter: Boolean?,
    val secondary_meter_date: String?,
    val secondary_meter_name: String?,
    val secondary_meter_unit: String?,
    val secondary_meter_usage_per_day: String?,
    val secondary_meter_value: Double?,
    val service_entries_count: Int?,
    val service_reminders_count: Int?,
    val specs: Specs?,
    val system_of_measurement: String?,
    val trim: String?,
    val type_name: String?,
    val updated_at: String?,
    val vehicle_renewal_reminders_count: Int?,
    val vehicle_status_color: String?,
    val vehicle_status_id: Int?,
    val vehicle_status_name: String?,
    val vehicle_type_id: Int?,
    val vehicle_type_name: String?,
    val vin: String?,
    val work_orders_count: Int?,
    val year: Int?
)