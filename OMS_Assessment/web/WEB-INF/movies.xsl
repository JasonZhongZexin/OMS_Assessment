<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : movies.xsl
    Created on : 30 September 2018, 12:32
    Author     : User
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
   

    <xsl:template match="movies">
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
                    <th>Movie Title</th>
                    <th>Genre</th>
                    <th>Relase date</th>
                    <th>Price</th>
                    <th>Available copies</th>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates />
            </tbody>
        </table>
    </xsl:template>

    <xsl:template match="movie">
        <tr>
            <td>
                <xsl:value-of select="title" />
            </td>
            <td>
                <xsl:value-of select="genre" />
            </td>
            <td>
                <xsl:value-of select="relase_date" />
            </td>
            <td>
                <xsl:value-of select="price" />
            </td>
            <td>
                <xsl:value-of select="available_copies" />
            </td>
            <td>
                <a>
                    <xsl:attribute name="href">
                        <xsl:text>checkOut.jsp?movieSelect=</xsl:text><xsl:value-of select="title"/>
                    </xsl:attribute>
                    Order Now
                </a>
            </td>
        </tr>
        
    </xsl:template>

</xsl:stylesheet>
