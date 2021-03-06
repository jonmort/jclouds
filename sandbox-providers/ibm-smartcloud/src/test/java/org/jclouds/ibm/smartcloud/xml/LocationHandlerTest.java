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

import org.jclouds.http.functions.BaseHandlerTest;
import org.jclouds.ibm.smartcloud.domain.Location;
import org.jclouds.ibm.smartcloud.reference.Capabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

/**
 * Tests behavior of {@code LocationHandler}
 * 
 * @author Adrian Cole
 */
@Test(groups = "unit", testName = "LocationHandlerTest")
public class LocationHandlerTest extends BaseHandlerTest {

   public void testApplyInputStream() {
      InputStream is = getClass().getResourceAsStream("/location.xml");

      Location result = factory.create(injector.getInstance(LocationHandler.class)).parse(is);

      Location expects = Location.builder().id("41").name("RTP").description("RTP usrdtsa0a1ccxra").location("RTP")
               .state(Location.State.ONLINE  ).capability(Capabilities.CAPABILITY_FORMAT,
                        ImmutableMap.<String, String> of("EXT3", "ext3", "RAW", "raw")).capability(
                        Capabilities.CAPABILITY_I386).capability(Capabilities.CAPABILITY_x86_64)
               .capability(Capabilities.CAPABILITY_AVAILABILITYAREA).build();

      assertEquals(result.toString(), expects.toString());
   }
}
