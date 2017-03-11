package com.franklyn.info.helper;

/**
 * Created by AGBOMA Franklyn on 3/17/2016.
 */
public class CountryCode {

/*    String[] countries = {
            Afghanistan, Albania, Algeria, American Samoa, Andorra,
            Angola, Anguilla, Antarctica, Antigua, Argentina,
            Armenia, Aruba, Australia, Austria, Azerbaijan, Barbuda,
            Bahamas	, Bahrain, Bangladesh, Barbados, Belarus, Belgium,
            Belize, Benin, Bermuda, Bhutan, Bolivia, Bosnia,
            Botswana, Brazil, British Indian Ocean Territory, British Virgin Islands,
            Brunei, Bulgaria, Burkina Faso, Burundi, Cambodia, Cameroon, Canada,
            Cape Verde, Cayman Islands, Central African Republic, Chad, Chile, China,
            Christmas Island, Cocos Islands, Colombia, Comoros, Cook Islands, Costa Rica,
            Croatia, Cuba, Curacao, Cyprus, Czech Republic, Democratic Republic of the Congo,
            Denmark, Djibouti, Dominica, Dominican Republic, East Timor,
            Ecuador, Egypt, El Salvador, Equatorial Guinea, Eritrea, Estonia, Ethiopia,
            Falkland Islands, Faroe Islands, Fiji, Finland, France, French Polynesia, Gabon,
            Gambia, Georgia, Germany, Ghana, Gibraltar, Greece, Greenland, Grenada, Guam,
            Guatemala, Guernsey, Guinea, Guinea Bissau, Guyana, Herzegovina, Haiti, Honduras,
            Hong Kong, Hungary, Iceland, India, Indonesia, Iran, Iraq, Ireland, Isle of Man,
            Israel, Italy, Ivory Coast, Jamaica, Japan, Jersey, Jordan, Kazakhstan, Kenya,
            Kiribati, Kosovo, Kuwait, Kyrgyzstan,
            Laos	856	LA / LAO	6,368,162	236,800	10.1 Billion
            Latvia	371	LV / LVA	2,217,969	64,589	30.38 Billion
            Lebanon	961	LB / LBN	4,125,247	10,400	43.49 Billion
            Lesotho	266	LS / LSO	1,919,552	30,355	2.457 Billion
            Liberia	231	LR / LBR	3,685,076	111,370	1.977 Billion
            Libya	218	LY / LBY	6,461,454	1,759,540	70.92 Billion
            Liechtenstein	423	LI / LIE	35,000	160	5.113 Billion
            Lithuania	370	LT / LTU	2,944,459	65,200	46.71 Billion
            Luxembourg	352	LU / LUX	497,538	2,586	60.54 Billion
            Macao	853	MO / MAC	449,198	254	51.68 Billion
            Macedonia	389	MK / MKD	2,062,294	25,333	10.65 Billion
            Madagascar	261	MG / MDG	21,281,844	587,040	10.53 Billion
            Malawi	265	MW / MWI	15,447,500	118,480	3.683 Billion
            Malaysia	60	MY / MYS	28,274,729	329,750	312.4 Billion
            Maldives	960	MV / MDV	395,650	300	2.27 Billion
            Mali	223	ML / MLI	13,796,354	1,240,000	11.37 Billion
            Malta	356	MT / MLT	403,000	316	9.541 Billion
            Marshall Islands	692	MH / MHL	65,859	181	193 Million
            Mauritania	222	MR / MRT	3,205,060	1,030,700	4.183 Billion
            Mauritius	230	MU / MUS	1,294,104	2,040	11.9 Billion
            Mayotte	262	YT / MYT	159,042	374
            Mexico	52	MX / MEX	112,468,855	1,972,550	1.327 Trillion
            Micronesia	691	FM / FSM	107,708	702	339 Million
            Moldova	373	MD / MDA	4,324,000	33,843	7.932 Billion
            Monaco	377	MC / MCO	32,965	2	5.748 Billion
            Mongolia	976	MN / MNG	3,086,918	1,565,000	11.14 Billion
            Montenegro	382	ME / MNE	666,730	14,026	4.518 Billion
            Montserrat	1-664	MS / MSR	9,341	102
            Morocco	212	MA / MAR	31,627,428	446,550	104.8 Billion
            Mozambique	258	MZ / MOZ	22,061,451	801,590	14.67 Billion
            Myanmar	95	MM / MMR	53,414,374	678,500	59.43 Billion
            Namibia	264	NA / NAM	2,128,471	825,418	12.3 Billion
            Nauru	674	NR / NRU	10,065	21
            Nepal	977	NP / NPL	28,951,852	140,800	19.34 Billion
            Netherlands	31	NL / NLD	16,645,000	41,526	722.3 Billion
            Netherlands Antilles	599	AN / ANT	136,197	960
            New Caledonia	687	NC / NCL	216,494	19,060	9.28 Billion
            New Zealand	64	NZ / NZL	4,252,277	268,680	181.1 Billion
            Nicaragua	505	NI / NIC	5,995,928	129,494	11.26 Billion
            Niger	227	NE / NER	15,878,271	1,267,000	7.304 Billion
            Nigeria	234	NG / NGA	154,000,000	923,768	502 Billion
            Niue	683	NU / NIU	2,166	260	10.01 Million
            North Korea	850	KP / PRK	22,912,177	120,540	28 Billion
            Northern Mariana Islands	1-670	MP / MNP	53,883	477	733 Million
            Norway	47	NO / NOR	5,009,150	324,220	515.8 Billion
            Oman	968	OM / OMN	2,967,717	212,460	81.95 Billion
            Pakistan	92	PK / PAK	184,404,791	803,940	236.5 Billion
            Palau	680	PW / PLW	19,907	458	221 Million
            Palestine	970	PS / PSE	3,800,000	5,970	6.641 Billion
            Panama	507	PA / PAN	3,410,676	78,200	40.62 Billion
            Papua New Guinea	675	PG / PNG	6,064,515	462,840	16.1 Billion
            Paraguay	595	PY / PRY	6,375,830	406,750	30.56 Billion
            Peru	51	PE / PER	29,907,003	1,285,220	210.3 Billion
            Philippines	63	PH / PHL	99,900,177	300,000	272.2 Billion
            Pitcairn	64	PN / PCN	46	47
            Poland	48	PL / POL	38,500,000	312,685	513.9 Billion
            Portugal	351	PT / PRT	10,676,000	92,391	219.3 Billion
            Puerto Rico	1-787, 1-939	PR / PRI	3,916,632	9,104	93.52 Billion
            Qatar	974	QA / QAT	840,926	11,437	213.1 Billion
            Republic of the Congo	242	CG / COG	3,039,126	342,000	14.25 Billion
            Reunion	262	RE / REU	776,948	2,517
            Romania	40	RO / ROU	21,959,278	237,500	188.9 Billion
            Russia	7	RU / RUS	140,702,000	17,100,000	2.113 Trillion
            Rwanda	250	RW / RWA	11,055,976	26,338	7.7 Billion
            Saint Barthelemy	590	BL / BLM	8,450	21
            Saint Helena	290	SH / SHN	7,460	410
            Saint Kitts and Nevis	1-869	KN / KNA	51,134	261	767 Million
            Saint Lucia	1-758	LC / LCA	160,922	616	1.377 Billion
            Saint Martin	590	MF / MAF	35,925	53	561.5 Million
            Saint Pierre and Miquelon	508	PM / SPM	7,012	242	215.3 Million
            Saint Vincent and the Grenadines	1-784	VC / VCT	104,217	389	742 Million
            Samoa	685	WS / WSM	192,001	2,944	705 Million
            San Marino	378	SM / SMR	31,477	61	1.866 Billion
            Sao Tome and Principe	239	ST / STP	175,808	1,001	311 Million
            Saudi Arabia	966	SA / SAU	25,731,776	1,960,582	718.5 Billion
            Senegal	221	SN / SEN	12,323,252	196,190	15.36 Billion
            Serbia	381	RS / SRB	7,344,847	88,361	43.68 Billion
            Seychelles	248	SC / SYC	88,340	455	1.271 Billion
            Sierra Leone	232	SL / SLE	5,245,695	71,740	4.607 Billion
            Singapore	65	SG / SGP	4,701,069	693	295.7 Billion
            Sint Maarten	1-721	SX / SXM	37,429	34	794.7 Million
            Slovakia	421	SK / SVK	5,455,000	48,845	96.96 Billion
            Slovenia	386	SI / SVN	2,007,000	20,273	46.82 Billion
            Solomon Islands	677	SB / SLB	559,198	28,450	1.099 Billion
            Somalia	252	SO / SOM	10,112,453	637,657	2.372 Billion
            South Africa	27	ZA / ZAF	49,000,000	1,219,912	353.9 Billion
            South Korea	82	KR / KOR	48,422,644	98,480	1.198 Trillion
            South Sudan	211	SS / SSD	8,260,490	644,329	11.77 Billion
            Spain	34	ES / ESP	46,505,963	504,782	1.356 Trillion
            Sri Lanka	94	LK / LKA	21,513,990	65,610	65.12 Billion
            Sudan	249	SD / SDN	35,000,000	1,861,484	52.5 Billion
            Suriname	597	SR / SUR	492,829	163,270	5.009 Billion
            Svalbard and Jan Mayen	47	SJ / SJM	2,550	62,049
            Swaziland	268	SZ / SWZ	1,354,051	17,363	3.807 Billion
            Sweden	46	SE / SWE	9,555,893	449,964	552 Billion
            Switzerland	41	CH / CHE	7,581,000	41,290	646.2 Billion
            Syria	963	SY / SYR	22,198,110	185,180	64.7 Billion
            Taiwan	886	TW / TWN	22,894,384	35,980	484.7 Billion
            Tajikistan	992	TJ / TJK	7,487,489	143,100	8.513 Billion
            Tanzania	255	TZ / TZA	41,892,895	945,087	31.94 Billion
            Thailand	66	TH / THA	67,089,500	514,000	400.9 Billion
            Togo	228	TG / TGO	6,587,239	56,785	4.299 Billion
            Tokelau	690	TK / TKL	1,466	10
            Tonga	676	TO / TON	122,580	748	477 Million
            Trinidad and Tobago	1-868	TT / TTO	1,228,691	5,128	27.13 Billion
            Tunisia	216	TN / TUN	10,589,025	163,610	48.38 Billion
            Turkey	90	TR / TUR	77,804,122	780,580	821.8 Billion
            Turkmenistan	993	TM / TKM	4,940,916	488,100	40.56 Billion
            Turks and Caicos Islands	1-649	TC / TCA	20,556	430
            Tuvalu	688	TV / TUV	10,472	26	38 Million
            U.S. Virgin Islands	1-340	VI / VIR	108,708	352
            Uganda	256	UG / UGA	33,398,682	236,040	22.6 Billion
            Ukraine	380	UA / UKR	45,415,596	603,700	175.5 Billion
            United Arab Emirates	971	AE / ARE	4,975,593	82,880	390 Billion
            United Kingdom	44	GB / GBR	62,348,447	244,820	2.49 Trillion
            United States	1	US / USA	310,232,863	9,629,091	16.72 Trillion
            Uruguay	598	UY / URY	3,477,000	176,220	57.11 Billion
            Uzbekistan	998	UZ / UZB	27,865,738	447,400	55.18 Billion
            Vanuatu	678	VU / VUT	221,552	12,200	828 Million
            Vatican	379	VA / VAT	921	0
            Venezuela	58	VE / VEN	27,223,228	912,050	367.5 Billion
            Vietnam	84	VN / VNM	89,571,130	329,560	170 Billion
            Wallis and Futuna	681	WF / WLF	16,025	274
            Western Sahara	212	EH / ESH	273,008	266,000
            Yemen	967	YE / YEM	23,495,361	527,970	43.89 Billion
            Zambia	260	ZM / ZMB	13,460,305	752,614	22.24 Billion
            Zimbabwe	263	ZW / ZWE	11,651,858	390,580	10.48 Billion

    };

    int[] countryCode = {
            93,355,213,1-684,376,244,1-264,672,1-268,54,374,297,61,43,994,1-268,1-242,
            973,880,1-246,375,32,501,229,1-441,975,591,387,267,55,246,1-284,673,359,
            226,257,855,237,1,238,1-345,236,235,56,86,61,61,57,269,682,506,385,53,
            599,357,420,243,45,253,1-767,1-809,670,593,20,503,240,291,372,251,500,
            298,679,358,33,689,241,220,995,49,233,350,30,299,1-473,1-671,502,44-1481,
            224,245,592,387,509,504,852,36,354,91,62,98,964,353,44-1624,972,39,225,1-876,
            81,44-1534,962,7,254,686,383,965,996,
    };*/
}
