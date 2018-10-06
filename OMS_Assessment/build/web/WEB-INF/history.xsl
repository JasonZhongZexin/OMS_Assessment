<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : history.xsl
    Created on : 3 October 2018, 12:50 AM
    Author     : zhongzexin
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="history">
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
                    <th>Order ID</th>
                    <th>Payment Method</th>
                    <th>Sale Total</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates />
            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="order">
        <tr>
            <td>
                <xsl:value-of select="ID" />
            </td>
            <td>
                <xsl:value-of select="paymentMethod" />
            </td>
            <td>
                <xsl:value-of select="saleTotal" />
            </td>
            <td>
                <xsl:value-of select="status" />
            </td>
            <td>
                <xsl:if test="status = 'submitted' ">
                    <a>
                        <xsl:attribute name="href">
                            <xsl:text>cancel.jsp?bookingIDSelect=</xsl:text>
                            <xsl:value-of select="ID"/>
                        </xsl:attribute>
                        Cancel Order
                    </a>
                </xsl:if>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>
