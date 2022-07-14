/*
 * Copyright 2015 Yann Le Moigne
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.javatic.mongo.jacksonCodec.javaTime.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.undercouch.bson4jackson.deserializers.BsonDateDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

public class InstantDeserializer extends JsonDeserializer<Instant> {

    private final BsonDateDeserializer bsonDateDeserializer;

    public InstantDeserializer() {
        this(new BsonDateDeserializer());
    }

    public InstantDeserializer(BsonDateDeserializer bsonDateDeserializer) {
        this.bsonDateDeserializer = bsonDateDeserializer;
    }


    @Override
    public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        Date date = bsonDateDeserializer.deserialize(p, ctxt);

        return Instant.ofEpochMilli(date.getTime());
    }
}
