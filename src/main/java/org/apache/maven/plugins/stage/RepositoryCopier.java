package org.apache.maven.plugins.stage;

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

import org.apache.maven.wagon.WagonException;
import org.apache.maven.wagon.repository.Repository;

import java.io.IOException;

/**
 * @author Jason van Zyl
 */
public interface RepositoryCopier
{
    String ROLE = RepositoryCopier.class.getName();

    String IN_PROCESS_MARKER = ".rip";

    String MD5 = "md5";

    String SHA1 = "sha1";

    String MAVEN_METADATA = "maven-metadata.xml";

    /**
     * @deprecated use {@link #copy(String, Repository, String)} so the server configuration applies 
     */
    void copy( String source, String target, String version )
        throws WagonException, IOException;

    void copy( String sourceRepositoryUrl, Repository targetRepository, String version )
        throws WagonException, IOException;

    void copy( String sourceRepositoryUrl, Repository targetRepository, String version, String username )
        throws WagonException, IOException;
}
