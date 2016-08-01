<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method='html' version='1.0' encoding='UTF-8' indent='yes'/>


<xsl:template match="/">
<html>
	<body>
		<h2>National Bookstore</h2>
		
		<table border="1">
			<tr bgcolor="red">
				<th align="left">Price</th>
			</tr>
			<xsl:for-each select="bookstore/book">
				<tr>
					<td><xsl:value-of select="price"/></td>
				</tr>
			</xsl:for-each>
		</table>
		
		<br/>
		
		<table border="1">
			<tr bgcolor="red">
				<th align="left">Price</th>
			</tr>
			
			<xsl:for-each select="bookstore/book">
			
				<xsl:choose>
					<xsl:when test="price &gt; 35">
						<tr>
							<td><xsl:value-of select="price"/></td>
						</tr>
					</xsl:when>
				</xsl:choose>
				
			</xsl:for-each>
		</table>
		
	</body>
</html>
</xsl:template>
</xsl:stylesheet>