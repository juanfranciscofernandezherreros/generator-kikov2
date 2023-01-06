package com.bme.clp.bck.q.domain.model.mongo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "TEST")
public class ModelDAO {

  @MongoId
  private ModelPKDAO id;
  <% for (let i=0; i<columns.length; i++) { %>
	@Field(name = "<%= columns[i].attributeName %>")
	private <%= columns[i].attributeType %> <%= columns[i].attributeName %>;
  <% } %>
}