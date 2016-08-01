<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<center>
				<body>
					<h2>Books and Prices</h2>
					<p>(Select all the text from price nodes)</p>
					<table border="1">
						<tr>
							<th>Title</th>
							<th>Prices</th>
						</tr>
						<xsl:for-each select="bookstore/book">
							<tr>
								<td><xsl:value-of select="title"/></td>
								<td><xsl:value-of select="price"/></td>
							</tr>
						</xsl:for-each>
					</table>
					<hr/>
					<h2>Books and Prices</h2>
					<p>(Select all the text from price nodes if price is higher than 35)</p>
					<table border="1">
						<tr>
							<th>Title</th>
							<th>Prices</th>
						</tr>
						<xsl:for-each select="bookstore/book">
							<tr>
							<xsl:if test="price &gt; 35">
								<td><xsl:value-of select="title"/></td>
								<td><xsl:value-of select="price"/></td>
							</xsl:if>
							</tr>
						</xsl:for-each>
					</table>
					
				</body>
			</center>
		</html>
	</xsl:template>

</xsl:stylesheet>