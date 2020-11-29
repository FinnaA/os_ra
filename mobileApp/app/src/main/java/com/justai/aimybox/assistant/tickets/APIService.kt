package com.justai.aimybox.assistant.tickets

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*


interface APIService {
    /*
       POST METHOD
    */
    @POST("/create_action_ticket")
    suspend fun createEmployee(@Body requestBody: RequestBody): Response<ResponseBody>
    /*****************************************************************************************************************************************************/
    /*
        GET METHOD
    */
    @GET("/action_tickets")
    suspend fun getEmployees(): Response<ResponseBody>
    /*****************************************************************************************************************************************************/
    /*
       PUT METHOD
    */
    @PUT("/api/v1/tickets/2")
    suspend fun updateEmployee(@Body requestBody: RequestBody): Response<ResponseBody>

    /*****************************************************************************************************************************************************/
    /*
       DELETE METHOD
    */
    @DELETE("/api/v1/tickets/2")
    suspend fun deleteEmployee(): Response<ResponseBody>
    /*****************************************************************************************************************************************************/
}