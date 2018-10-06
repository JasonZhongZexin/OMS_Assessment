<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : orderItem.xsl
    Created on : 7 October 2018, 6:12 AM
    Author     : zhongzexin
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
<xsl:template match="order">
        <style>
            table{
            width:60%;
            }
            th, td {
            padding: 8px;
            }
            th {
            background-color: #0099FF;
            color: white;
            font-weight:bold;
            }
            h2,p{
            font-family:Arial;
            sans-serif;
            text-align:center;
            width:60%;
            font-weight:bold;
            }		
            tbody{
            background-color: white; 
            font-weight:bold;
            text-align:center;
            }			
        </style>
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Genre</th>
                    <th>Release Year</th>
                    <th>Copies Purchased</th>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates />
            </tbody>
        </table>
    </xsl:template>
        <xsl:template match="orderItem">
        <tr>
            <td>
                <xsl:value-of select="movieTitle" />
            </td>
            <td>
                <xsl:value-of select="movieGenre" />
            </td>
            <td>
                <xsl:value-of select="releaseDate" />
            </td>
            <td>
                <xsl:value-of select="copiesPurchased" />
            </td>
        </tr>
    </xsl:template>

</xsl:stylesheet>
