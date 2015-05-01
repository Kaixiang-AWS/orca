/*
 * Copyright 2015 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.orca.mine

import retrofit.client.Response
import retrofit.http.Body
import retrofit.http.DELETE
import retrofit.http.GET
import retrofit.http.POST
import retrofit.http.PUT
import retrofit.http.Path
import retrofit.http.Query

interface MineService {
  @POST('/registerCanary')
  Response registerCanary(@Body Map canary)

  @GET('/canaries/{id}')
  Map getCanary(@Path('id') String id)

  @DELETE('/canaries/{id}/cancel')
  Map cancelCanary(@Path('id') String id, @Query('reason') String reason)

  @PUT('/canaries/{id}/disable')
  Map disableCanary(@Path('id') String id, @Query('reason') String reason)

  @PUT('/canaries/{id}/enable')
  Map enableCanary(@Path('id') String id)

  @PUT('/canaries/{id}/disableAndScheduleForTermination')
  Map disableCanaryAndScheduleForTermination(@Path('id') String id, @Query('reason') String reason)
}
