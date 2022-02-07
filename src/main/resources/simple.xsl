<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
        <table>
            <xsl:copy>
                <xsl:apply-templates select="//city" />
            </xsl:copy>
        </table>
    </xsl:template>

    <xsl:template match="city">
        <row>
            <country>
                <xsl:value-of select="../../@Name"/>
            </country>
            <province>
                <xsl:value-of select="../@Name"/>
            </province>
            <city>
                <xsl:value-of select="./@Name"/>
            </city>
        </row>

    </xsl:template>

</xsl:stylesheet>