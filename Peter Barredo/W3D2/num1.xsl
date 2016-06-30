<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="/bookstore">
		<html>
			<head>
				<title>Number 1</title>
			</head>
			<body>
				<table border="1">
				    <tr bgcolor="#9acd32">
				      <th>Price</th>
				    </tr>
				   <xsl:for-each select="book">
				    <tr>
				      <td><xsl:value-of select="price"/></td>
				    </tr>
				    </xsl:for-each>
				  </table>
				  <br/> <br/>
			
				  <table border="1">
				    <tr bgcolor="#9acd32">
				      <th>Price</th>
				    </tr>
				   <xsl:for-each select="book">
				    <tr>
					<xsl:if test="price  &gt; 35">
					  <td><xsl:value-of select="price"/></td>
					</xsl:if> 
				    </tr>
				    </xsl:for-each>
				  </table>
			</body>
		</html>		
	</xsl:template>
</xsl:stylesheet>