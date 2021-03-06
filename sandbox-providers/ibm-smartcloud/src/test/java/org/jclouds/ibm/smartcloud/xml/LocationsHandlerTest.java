/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.ibm.smartcloud.xml;

import static org.testng.Assert.assertEquals;

import java.io.InputStream;
import java.util.Set;

import org.jclouds.http.functions.BaseHandlerTest;
import org.jclouds.ibm.smartcloud.domain.Location;
import org.jclouds.ibm.smartcloud.reference.Capabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * Tests behavior of {@code LocationsHandler}
 * 
 * @author Adrian Cole
 */
@Test(groups = "unit", testName = "ibm.smartcloud.LocationsHandlerTest")
public class LocationsHandlerTest extends BaseHandlerTest {

   @Test
   public void testAllLocations() {
      InputStream is = getClass().getResourceAsStream("/locations.xml");

      Set<? extends Location> result = factory.create(injector.getInstance(LocationsHandler.class)).parse(is);

      Set<? extends Location> expects = ImmutableSet.of(Location.builder().id("41").name("RTP").description(
               "RTP usrdtsa0a1ccxra").location("RTP").state(Location.State.ONLINE  ).capability(
               Capabilities.CAPABILITY_FORMAT, ImmutableMap.<String, String> of("EXT3", "ext3", "RAW", "raw"))
               .capability(Capabilities.CAPABILITY_I386).capability(Capabilities.CAPABILITY_x86_64).capability(
                        Capabilities.CAPABILITY_AVAILABILITYAREA).build(),

      Location.builder().id("61").name("EHN").location("EHN").state(Location.State.ONLINE  )
               .capability(Capabilities.CAPABILITY_FORMAT,
                        ImmutableMap.<String, String> of("EXT3", "ext3", "RAW", "raw")).capability(
                        Capabilities.CAPABILITY_I386).capability(Capabilities.CAPABILITY_x86_64).capability(
                        Capabilities.CAPABILITY_AVAILABILITYAREA).build(),

               Location.builder().id("82").name("us-co-dc1").description("BLD main DC").location("us-co-dc1").state(
                        Location.State.ONLINE  ).capability(Capabilities.CAPABILITY_FORMAT,
                        ImmutableMap.<String, String> of("EXT3", "ext3", "RAW", "raw")).capability(
                        Capabilities.CAPABILITY_I386).capability(Capabilities.CAPABILITY_x86_64).capability(
                        Capabilities.CAPABILITY_AVAILABILITYAREA).build(),

               Location.builder().id("101").name("ca-on-dc1").description("Data Center 1 at Ontario, Canada").location(
                        "ca-on-dc1").state(Location.State.ONLINE  ).capability(Capabilities.CAPABILITY_FORMAT,
                        ImmutableMap.<String, String> of("EXT3", "ext3", "RAW", "raw")).capability(
                        Capabilities.CAPABILITY_I386).capability(Capabilities.CAPABILITY_x86_64).capability(
                        Capabilities.CAPABILITY_AVAILABILITYAREA).build(),

               Location.builder().id("121").name("ap-jp-dc1").description("Data Center 1 at Makuhari, Japan").location(
                        "ap-jp-dc1").state(Location.State.ONLINE  ).capability(Capabilities.CAPABILITY_FORMAT,
                        ImmutableMap.<String, String> of("EXT3", "ext3", "RAW", "raw")).capability(
                        Capabilities.CAPABILITY_I386).capability(Capabilities.CAPABILITY_x86_64).capability(
                        Capabilities.CAPABILITY_AVAILABILITYAREA).build(),

               Location.builder().id("141").name("ap-sg-dc1").description("Data Center 1 at Singapore").location(
                        "ap-sg-dc1").state(Location.State.ONLINE  ).capability(Capabilities.CAPABILITY_FORMAT,
                        ImmutableMap.<String, String> of("EXT3", "ext3", "RAW", "raw")).capability(
                        Capabilities.CAPABILITY_I386).capability(Capabilities.CAPABILITY_x86_64).capability(
                        Capabilities.CAPABILITY_AVAILABILITYAREA).build()

      );

      assertEquals(result.toString(), expects.toString());

   }

}
