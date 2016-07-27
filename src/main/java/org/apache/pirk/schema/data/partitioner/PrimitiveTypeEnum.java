/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
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

package org.apache.pirk.schema.data.partitioner;


import org.apache.pirk.utils.SystemConfiguration;

public enum PrimitiveTypeEnum implements TypeEnum
{
  BYTE(Byte.SIZE),
  SHORT(Short.SIZE),
  INT(Integer.SIZE),
  LONG(Long.SIZE),
  FLOAT(Float.SIZE),
  DOUBLE(Double.SIZE),
  CHAR(Character.SIZE),
  STRING(Integer.parseInt(SystemConfiguration.getProperty("pir.stringBits")));

  private int size;
  
  PrimitiveTypeEnum(int size)
  {
    this.size = size;
  }

  public int size() 
  {
    return this.size;
  }
  
  /**
   * Method to get the number of 8-bit partitions given the element type
   */
  public int numPartitions()
  {
    return this.size / 8; 
  }
  
}
