<% for (let i=0; i<columns.length; i++) { %>
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
@Document(collection ="<%=columns[i].mongoCollection%>")
public class <%= columns[i].modelName %>DAO {

  @MongoId
  private <%= columns[i].modelName %>PKDAO id;
	@Field(name = "<%= columns[i].attributeName %>")
	private <%= columns[i].attributeType %> <%= columns[i].attributeName %>;
  <% } %>
}