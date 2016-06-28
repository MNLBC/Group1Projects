<?xml version="1.0" encoding="UTF-8"?>
<!-- Copyright (c) 2006-2007, Juniper Networks, Inc. -->
<!-- All rights reserved -->

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs xsi xsl">
	<xsl:output method="xml" encoding="UTF-8" indent="yes" />

	<xsl:template match="/rpc-reply-converter-input">
		<rpc-reply-converter-output>
			<dmi-specific-rpc-reply>

				<chassis-satellites>
					<xsl:for-each
						select="device-specific-rpc-reply-list/device-specific-rpc-reply">
						<xsl:choose>
							<xsl:when test="position() = 1">
								<xsl:for-each select="satellite-information/satellite">
									<chassis-satellite>
										<xsl:if test="satellite-alias">
											<satelliteName>
												<xsl:value-of select="satellite-alias" />
											</satelliteName>
										</xsl:if>
										<xsl:if test="slot-id">
											<slotId>
												<xsl:value-of select="slot-id" />
											</slotId>
										</xsl:if>
										<xsl:if test="product-model">
											<productModel>
												<xsl:value-of select="product-model" />
											</productModel>
										</xsl:if>
										<xsl:if test="version">
											<version>
												<xsl:value-of select="version" />
											</version>
										</xsl:if>
										<xsl:if test="management-address">
											<managementAddress>
												<xsl:value-of select="management-address" />
											</managementAddress>
										</xsl:if>

										<xsl:if test="//group-name">
											<groupName>
												<xsl:value-of select="//group-name" />
											</groupName>
										</xsl:if>

										<xsl:if test="//version">
											<groupVersion>
												<xsl:value-of select="//version" />
											</groupVersion>
										</xsl:if>

										<xsl:for-each select="connectivity">
											<connectivity>
												<xsl:if test="cascade-port">
													<cascadePort>
														<xsl:value-of select="cascade-port" />
													</cascadePort>
												</xsl:if>
												<xsl:if test="uplink-interface-name">
													<uplinkIntefaceName>
														<xsl:value-of select="uplink-interface-name" />
													</uplinkIntefaceName>
												</xsl:if>
												<xsl:if test="adjacency-state">
													<adjacencyState>
														<xsl:value-of select="adjacency-state" />
													</adjacencyState>
												</xsl:if>
											</connectivity>
										</xsl:for-each>

									</chassis-satellite>

								</xsl:for-each>

							</xsl:when>
						</xsl:choose>
					</xsl:for-each>
				</chassis-satellites>
			</dmi-specific-rpc-reply>
		</rpc-reply-converter-output>
	</xsl:template>
</xsl:stylesheet>


        
