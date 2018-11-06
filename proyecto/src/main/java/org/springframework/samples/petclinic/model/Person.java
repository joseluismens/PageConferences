/*
 * Copyright 2002-2013 the original author or authors.
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
package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Simple JavaBean domain object representing an person.
 *
 * @author Ken Krebs
 */
@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "name")
    @NotEmpty
    protected String name;

    @Column(name = "correo")
    @NotEmpty
    protected String correo;
    
    @Column(name = "sexo")
    @NotEmpty
    protected char sexo;

    @Column(name = "fono")
    @NotEmpty
    protected int fono;


    public String getName() {
        return this.name;
    }

    public void settName(String name) {
        this.name = name;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {

        this.correo = correo;
    }

    public char getSexo() {
    	return this.sexo; 	
    }
    public void setSexo(char sexo) {
    	this.sexo=sexo;
    }
    public int getFono() {
    	return this.fono; 	
    }
    public void seFono(int fono) {
    	this.fono=fono;
    }
   
}