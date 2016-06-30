<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <body>
        <h2>All Prices</h2>

        <table border="1">
          <tr bgcolor="#9acd32">
            <tr>
              <th>All Prices</th>
            </tr>
          </tr>
          <xsl:for-each select="bookstore/book">
            <xsl:sort select="price" />
            <tr>
              <td>
                <xsl:value-of select="price" />
              </td>
            </tr>
          </xsl:for-each>
        </table>


        <h2>With Higher Prices </h2>
        <table border="1">
          <tr bgcolor="#9acd32">
            <tr>
              <th>Higher Prices</th>
            </tr>
          </tr>
          <xsl:for-each select="bookstore/book">
            <xsl:sort select="price" />
            <xsl:if test="price > 35">
              <tr>
                <td>
                  <xsl:value-of select="price" />
                </td>
              </tr>
            </xsl:if>
          </xsl:for-each>
        </table>

      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>