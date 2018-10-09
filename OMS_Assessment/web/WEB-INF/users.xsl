<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : users.xsl
    Created on : 8 October 2018, 12:09 AM
    Author     : zhongzexin
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    -->
    <xsl:template match="users">
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
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates />
            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="user">
        <tr>
            <td>
                <xsl:value-of select="fullName" />
            </td>
            <td>
                <xsl:value-of select="email" />
            </td>
            <td>
                <xsl:value-of select="password" />
            </td>
            <td>
                <xsl:value-of select="phoneNumber" />
            </td>
            <td>
                <xsl:value-of select="address"/>
            </td>
        </tr>
    </xsl:template>

</xsl:stylesheet>
