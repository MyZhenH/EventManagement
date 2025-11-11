INSERT INTO users (
    first_name, last_name, email, phone, password, registration_date, role_id, enabled
) VALUES
    -- Original password: pass1234
    ('Emma', 'Peterson', 'emma.peterson@example.com', '+4670001001', '$2b$10$5oKLXSqgvuAgpqt5c7AwDuReMu88eZUVuD.KP6Ea.y0oPHg9cl3Yy', '2024-12-17 09:15:22', 1, 1),
    -- Original password: pass5678
    ('Liam', 'Andersson', 'liam.andersson@example.com', '+4670001002', '$2b$10$zSbxl2jHQAW0eWUOMpazierCS6yZj4MtaABV.zQBnrCMDar26fgeC', '2025-03-08 14:45:10', 3, 1),
    -- Original password: pass9101
    ('Noah', 'Johansson', 'noah.johansson@example.com', '+4670001003', '$2b$10$neVc3GRBynC05YmAxNuHw.8ibWVugtlfiKg4DbqHFyeNyXREEtAGK', '2025-01-25 18:00:00', 3, 0),
    -- Original password: pass1121
    ('Maja', 'Karlsson', 'maja.karlsson@example.com', '+4670001004', '$2b$10$ebYYe2YjncOXybeVkhLULOO6yyNPFRsm9c8f7uWHI6uIIHVH8fr.y', '2024-11-05 20:12:34', 2, 1),
    -- Original password: pass3141
    ('Oskar', 'Svensson', 'oskar.svensson@example.com', '+4670001005', '$2b$10$LKYvSRZE5NeU8t3OQ2k.ZunO7zIcU3Wd/0dsP74745EXggY2YdF1K', '2025-05-19 10:30:20', 3, 1),
    -- Original password: pass5161
    ('Elsa', 'Nilsson', 'elsa.nilsson@example.com', '+4670001006', '$2b$10$/0n4XYKOU4OuY8Vt3c6qu.3vnIjULoGfacx0A/mpoKAgRdmvCziye', '2025-02-14 08:25:55', 3, 0),
    -- Original password: pass7181
    ('Lucas', 'Gustafsson', 'lucas.gustafsson@example.com', '+4670001007', '$2b$10$KgCUSSOeCaK5.sNnVcPGlOTCcbkQaT6bmqobE72cX6zCCnRAwuMP6', '2024-11-29 16:40:43', 2, 1),
    -- Original password: pass9202
    ('Alice', 'Olsson', 'alice.olsson@example.com', '+4670001008', '$2b$10$PcKHoUXozzTbVCOvqTRRq.aaoia4mDZlg.srHRuG6nK7DZr8g/HIK', '2024-10-22 11:55:09', 3, 1),
    -- Original password: pass1222
    ('William', 'Larsson', 'william.larsson@example.com', '+4670001009', '$2b$10$glt9cQe.64ao3Nc.apxPJuqpJtlxXcJ6YYzYt/DMjEEUejXAEIAuO', '2025-06-01 15:05:30', 3, 1),
    -- Original password: pass3242
    ('Ella', 'Lindberg', 'ella.lindberg@example.com', '+4670001010', '$2b$10$BywWYDxCVq63L/4srflyx.ahBS.51qTzygESgCRIaMSRJfPHZ6KcS', '2025-04-18 19:22:01', 3, 0),
    -- Original password: pass4262
    ('Oliver', 'Berg', 'oliver.berg@example.com', '+4670001011', '$2b$10$Ja3cXj9RUKHvavCdUBv.SOdqfcIMTcaURR8K0fZqs00YLVx6Jp.P6', '2024-11-14 13:11:05', 3, 1),
    -- Original password: pass6282
    ('Saga', 'Sjöberg', 'saga.sjoberg@example.com', '+4670001012', '$2b$10$iFxsRv81BDiSpJX4CkzD5uz596FxI2eyCrclLQVpXGRD5g5LRvicW', '2024-12-01 07:35:40', 2, 1),
    -- Original password: pass8303
    ('Viktor', 'Holm', 'viktor.holm@example.com', '+4670001013', '$2b$10$O5fwU4ZfCG9xwNC9RBAtV.E7OwXbh31Q4nYhDV5p98FdmX07rdyQe', '2025-03-23 23:40:50', 3, 1),
    -- Original password: pass0324
    ('Freja', 'Lund', 'freja.lund@example.com', '+4670001014', '$2b$10$lqJho/r.QaXHekjs.3tOkOf/Atiwh.25fcviBil2GzYPGg63POO9W', '2025-05-14 11:25:36', 1, 1),
    -- Original password: pass2344
    ('Filip', 'Fredriksson', 'filip.fredriksson@example.com', '+4670001015', '$2b$10$fIKMjSOPK6nVUKrsRjVtduMB8uIQqEvrDqbkXbK59RhGvMEaWAEKm', '2024-10-28 10:10:10', 3, 0),
    -- Original password: pass4364
    ('Alva', 'Nyman', 'alva.nyman@example.com', '+4670001016', '$2b$10$MnMs3SEjZiEzPraQ883sTeyfldje9MXZ1SubYu6NXWOsTP5dTXRPe', '2025-01-02 18:48:36', 3, 1),
    -- Original password: pass6385
    ('Isak', 'Bergström', 'isak.bergstrom@example.com', '+4670001017', '$2b$10$Do.oEAmIYb/LmVVhdYe/Yu9ZdVeeBAIHDpxIE6wsJ6OUVHXc5q5Gq', '2025-02-20 14:17:29', 2, 1),
    -- Original password: pass8406
    ('Alva', 'Wikström', 'alva.wikstrom@example.com', '+4670001018', '$2b$10$/mlJyCGm5yJR/UDftp0ogeisYBI.MKBBO5bcnI4mWrjFQbE7o3Oqi', '2024-11-01 22:15:18', 3, 1),
    -- Original password: pass0427
    ('Hugo', 'Sundberg', 'hugo.sundberg@example.com', '+4670001019', '$2b$10$Um/w2b8SKtWh8SG63HPFlOTILE3evC9KFHT1LM/h1T007WwMfD352', '2025-06-04 08:09:12', 1, 0),
    -- Original password: pass2447
    ('Ebba', 'Axelsson', 'ebba.axelsson@example.com', '+4670001020', '$2b$10$N4.fDINuPdoxwLTT/l8PROM2aA2iXyx2jXrnXFvrtBzfe16IMeTUG', '2025-04-19 20:35:45', 3, 1),
    -- Original password: pass4467
    ('Albin', 'Lindström', 'albin.lindstrom@example.com', '+4670001021', '$2b$10$QrDt/PrRh4S9/NRw.ywQG.MUsG1.rtmuw7TWo8Fs9JuV0NFvmOwKS', '2024-12-11 15:55:28', 3, 1),
    -- Original password: pass6488
    ('Wilma', 'Öberg', 'wilma.oberg@example.com', '+4670001022', '$2b$10$oslFAsg7n.LEKPsK6b7uKee4PkvAz0Wp3To9NkYPKGenVjsaini9W', '2025-03-17 09:52:11', 3, 0),
    -- Original password: pass8509
    ('Axel', 'Holmberg', 'axel.holmberg@example.com', '+4670001023', '$2b$10$IwQEwhBdx2O4xa4H7LSW3ePcl8bbKAIRAVG0jZFTObpb9AknLhkra', '2025-01-30 07:44:59', 2, 1),
    -- Original password: pass0520
    ('Saga', 'Blom', 'saga.blom1@example.com', '+4670001024', '$2b$10$UQ7Y4AJotpO7RvKjonHyGOczclhvTZqikMdTjHG6.GWxisSgrwzAe', '2025-05-23 19:23:35', 3, 1), -- Updated
    -- Original password: pass2540
    ('Elias', 'Jansson', 'elias.jansson@example.com', '+4670001025', '$2b$10$NUWUeWVtp3rzExPvr0WIUexAcmhPHVLcGp6zMlDH8yij0nImjvhLS', '2025-02-07 12:05:50', 3, 1),
    -- Original password: pass4560
    ('Alma', 'Ström', 'alma.strom@example.com', '+4670001026', '$2b$10$.rs3ffcz7K9HSiBeNi/A.OSWvEv9XaFLsj0/iIDjA6js70YqwdBXK', '2024-11-18 17:40:00', 3, 0),
    -- Original password: pass6581
    ('Leon', 'Engström', 'leon.engstrom@example.com', '+4670001027', '$2b$10$Z4Ot0qRgxQC6lwSRYLNnjOxYndS6grDmVLatORbvwa8kEP/i94i8i', '2025-06-05 11:18:22', 1, 1),
    -- Original password: pass8602
    ('Ella', 'Åkesson', 'ella.akesson@example.com', '+4670001028', '$2b$10$pTx8HPojm3mSYSy8wlnlYudmUK80BmNI9lrbB5jPf.gnbe2akKe7C', '2025-04-24 20:45:09', 3, 1),
    -- Original password: pass0623
    ('Albin', 'Gunnarsson', 'albin.gunnarsson@example.com', '+4670001029', '$2b$10$nStDIKIK951.eRlWL/wFFuT.9oe3Z3uatcAenntrfzLsBcVUEq5Mm', '2024-12-29 08:39:07', 3, 1),
    -- Original password: pass2643
    ('Maja', 'Lindqvist', 'maja.lindqvist@example.com', '+4670001030', '$2b$10$doGjZxQRoas4GOoKBeAoeuClr69DtHSnhHOb95eKYk.Zc0JCGWK3S', '2025-01-11 14:50:40', 2, 0),
    -- Original password: pass4663
    ('Noah', 'Rydberg', 'noah.rydberg@example.com', '+4670001031', '$2b$10$75XfkxxJgpO/dZEA0S6q6uQ3JGUHT5qm4Ga0TPncuZgM9Wo5OCwW6', '2024-11-25 18:40:33', 3, 1),
    -- Original password: pass6684
    ('Elsa', 'Magnusson', 'elsa.magnusson@example.com', '+4670001032', '$2b$10$7QbSXrU9cSyfYhq967TvpO05ynd3.A2OqhXto2LGrNjV/ZmSBgNsi', '2025-03-29 10:10:55', 3, 1),
    -- Original password: pass8705
    ('Viktor', 'Söderberg', 'viktor.soderberg@example.com', '+4670001033', '$2b$10$Vd9tbJnsRtSAOsMDBJ.v/edV27..cXOYc4HHGNrPKWdohWiZhM45u', '2025-05-04 15:22:11', 3, 1),
    -- Original password: pass0726
    ('Elsa', 'Lindgren', 'elsa.lindgren@example.com', '+4670001034', '$2b$10$isnOjt0kA.R8.l8Lg7CJUOK8LW/uh1PjIXgItuTGZ0KSODPO5cxI6', '2025-06-02 12:34:23', 2, 0),
    -- Original password: pass2746
    ('William', 'Nyström', 'william.nystrom@example.com', '+4670001035', '$2b$10$m0jjgodtNGhwHAOSVqaiZe4e.j3D51b1mGu.flL11QAu71JeSsUnW', '2025-01-05 13:17:07', 3, 1),
    -- Original password: pass4766
    ('Moa', 'Holmqvist', 'moa.holmqvist@example.com', '+4670001036', '$2b$10$yeV9KOQs4Onea/H3xKOi5..dkkkYLuB87Lh4sHmMEZQCzVgfzVSjG', '2024-10-31 16:40:22', 3, 1),
    -- Original password: pass6787
    ('Leo', 'Björklund', 'leo.bjorklund@example.com', '+4670001037', '$2b$10$3vyD6Q0hYRzMO807cm0EI.z7HvL98a2TuyKAZGoP28pSVwh.lDtPS', '2025-03-12 09:01:54', 3, 1),
    -- Original password: pass8808
    ('Alma', 'Ågren', 'alma.agren@example.com', '+4670001038', '$2b$10$ybQ2U4AOLECnD1Kcntbd2OfJRduQsvxNj9FblP1MimbYBtSFPucFW', '2025-04-28 11:11:11', 3, 0),
    -- Original password: pass0829
    ('Axel', 'Axelsson', 'axel.axelsson@example.com', '+4670001039', '$2b$10$rIsdNmFvXR4WXfZREcmMNOcU6jp29kJp5JAGdsCtvCHTbfX6VkNqG', '2025-05-16 08:09:45', 1, 1),
    -- Original password: pass2849
    ('Saga', 'Lind', 'saga.lind@example.com', '+4670001040', '$2b$10$.i.nvnyAeUGgK2ohUi9nmOxwaXCfg78VTTe67jsmIBdZixX7zqGFO', '2024-12-20 17:25:10', 3, 1),
    -- Original password: pass4869
    ('Albin', 'Nyberg', 'albin.nyberg@example.com', '+4670001041', '$2b$10$OaXZq2Vwd3CA4b7wAK77B.2V1/UDDrIachuORs3aDnYtoas8D783C', '2025-02-28 14:40:03', 3, 1),
    -- Original password: pass6889
    ('Freja', 'Östman', 'freja.ostman@example.com', '+4670001042', '$2b$10$9tPNO/V7hnu6qA4eWqvEeOcTuFfXrzp98xOopSUl6GSDMGbI4GmW2', '2025-06-05 19:32:00', 3, 0),
    -- Original password: pass8900
    ('Elias', 'Ekström', 'elias.ekstrom@example.com', '+4670001043', '$2b$10$hPOPHGRB2nfscgy/W/JvW.NXbHLqAIgunIrElYU1CnjWeKtpa.LZC', '2025-01-19 06:45:48', 2, 1),
    -- Original password: pass0921
    ('Alva', 'Sjödin', 'alva.sjodin@example.com', '+4670001044', '$2b$10$Ju54nHPCbCxTbiDAvi/n5uahK6LcUq3HBZeBNvaPBLdrgnl4SAvPi', '2024-11-10 15:40:30', 3, 1),
    -- Original password: pass2941
    ('Isak', 'Hellström', 'isak.hellstrom@example.com', '+4670001045', '$2b$10$BzpDsa0rAK8jEcYshdN1D..w1re.c7yQeaFYULpG61HyPriO9Rt/S', '2025-03-16 12:22:05', 3, 1),
    -- Original password: pass4961
    ('Wilma', 'Nordin', 'wilma.nordin@example.com', '+4670001046', '$2b$10$Fb/gZN84BsCsfmhCtiraru2jhuiV7cbUGZdrJ/vmc.gECHZjpj6R2', '2025-05-27 13:15:50', 3, 1),
    -- Original password: pass6982
    ('Felix', 'Lindvall', 'felix.lindvall@example.com', '+4670001047', '$2b$10$XgvjOkipIZEtpnQH11rdSe4RIQlNOrHSdMOXqLGsr1WU86Wfs/srK', '2025-04-30 10:18:23', 3, 1),
    -- Original password: pass9002
    ('Ella', 'Åsberg', 'ella.asberg@example.com', '+4670001048', '$2b$10$iHj7H88TFEUgDy6MnZ3qLeUaN.BMJM92axUdd/BeinygoTy88MCwa', '2025-01-21 18:22:12', 1, 0),
    -- Original password: pass1023
    ('Leo', 'Bergman', 'leo.bergman@example.com', '+4670001049', '$2b$10$H6UZ7Mw.WiQqIWxNrh.ne.YY1QTWPJ2ZQsIndztS47PoGbqiPsKja', '2025-02-22 09:30:40', 3, 1),
    -- Original password: pass3043
    ('Alma', 'Jacobsson', 'alma.jacobsson@example.com', '+4670001050', '$2b$10$5r5sjRBU7MlabuJBgNU7eOjihLOaTvoxbS.cR5boKjYU3YSTWLuYC', '2025-03-25 07:40:44', 3, 1),
    -- Original password: pass5063
    ('Oscar', 'Persson', 'oscar.persson@example.com', '+4670001051', '$2b$10$WE/sJkRTuX2Oa/PWZyYHvuXvw.ZD.NHPbmEolwlTI6iW4gNyOmfVO', '2024-11-12 20:50:55', 3, 0),
    -- Original password: pass7083
    ('Moa', 'Hansson', 'moa.hansson@example.com', '+4670001052', '$2b$10$3hsRkz81iAEEyfEBCa8WXu4ljTVKQtFrRFde50n7qL3afJAFZnhSS', '2025-04-04 11:05:07', 2, 1),
    -- Original password: pass9104
    ('Viktor', 'Sandberg', 'viktor.sandberg@example.com', '+4670001053', '$2b$10$Zh..douVqNLmOs4W8REvC.Gm3rqv1Qp0Psg8o2pwSCQeHguFYX1E.', '2025-05-29 08:30:50', 3, 1),
    -- Original password: pass1124
    ('Emma', 'Wallin', 'emma.wallin@example.com', '+4670001054', '$2b$10$oa1rEPD98gNe7rGhmwRkSerAasHssVEJtLls.AbJ8kUN4AkscEzdK', '2024-12-15 19:40:12', 3, 1),
    -- Original password: pass3144
    ('Albin', 'Forsberg', 'albin.forsberg@example.com', '+4670001055', '$2b$10$SXln3tM/kdc.e39HL6o75.BiZLf6AoxJvUaHKrCbi9vNTxRykQJCi', '2025-06-03 16:20:41', 3, 0),
    -- Original password: pass5164
    ('Ella', 'Ek', 'ella.ek@example.com', '+4670001056', '$2b$10$FPRe1XoBzdp.YTKsCvo61OIEHVXf5evVqr1vgzfD1qJLZWh/UCiYO', '2025-02-09 14:15:33', 1, 1),
    -- Original password: pass7184
    ('Leo', 'Blomqvist', 'leo.blomqvist@example.com', '+4670001057', '$2b$10$ByTgd/HHFsd/3UaWmDdGVu2d7DgusYh2xzXN.D4I9hAe/fyw2X0xK', '2024-11-18 07:52:39', 3, 1),
    -- Original password: pass9205
    ('Maja', 'Sundström', 'maja.sundstrom@example.com', '+4670001058', '$2b$10$sWhbnGroiD7iMte7hlnQCujklnBZu0TZijczpfSNqH4uokvincbeq', '2025-03-21 10:42:51', 3, 1),
    -- Original password: pass1225
    ('Noah', 'Jönsson', 'noah.jonsson@example.com', '+4670001059', '$2b$10$pVHdGWU4CogFGiQV6zAlRuCsfpx7wUTW7olIb.vO6sjxGnoPZL2oG', '2025-05-18 12:35:27', 3, 0),
    -- Original password: pass3245
    ('Elsa', 'Lundgren', 'elsa.lundgren@example.com', '+4670001060', '$2b$10$mb8edb5fcQ4OXvCgtVk6EOP/ZT3DTK0dy2kMGbp/9pnSkJTCR6jx.', '2025-01-31 09:30:12', 3, 1),
    -- Original password: pass5265
    ('Oskar', 'Bergqvist', 'oskar.bergqvist@example.com', '+4670001061', '$2b$10$UNf1iwr9hziAKB3rqJ4hl.HweFruh0esHg3SPs4DlTmVXZXK4zNZK', '2025-04-22 20:10:41', 2, 1),
    -- Original password: pass7285
    ('Alva', 'Nyqvist', 'alva.nyqvist@example.com', '+4670001062', '$2b$10$mbOmjrN8F1DaWg0ntHv.GeUPKSHcsdTflo2k7ebWyZXlsLpmmwgt2', '2025-03-10 17:02:05', 3, 1),
    -- Original password: pass9306
    ('Felix', 'Lundqvist', 'felix.lundqvist@example.com', '+4670001063', '$2b$10$QDUm50cMnTcZ3NsADGjcLOarfLI9924qsw7rX5ut4J8mXeRVx36ly', '2024-11-06 21:22:29', 3, 0),
    -- Original password: pass1326
    ('Albin', 'Svensson', 'albin.svensson@example.com', '+4670001064', '$2b$10$s06gH2Ib9MMawlnvGWMG5uduGjCJVGWUUjIdozoCF8LKa0WwslAWe', '2024-12-01 07:14:51', 1, 1),
    -- Original password: pass3346
    ('Moa', 'Hedlund', 'moa.hedlund@example.com', '+4670001065', '$2b$10$/lD1Tx1qPRIuGxUPXJ/8yevlg42qa5PnSXIol4S6429vV57IhDKYm', '2025-02-12 16:10:23', 3, 1),
    -- Original password: pass5366
    ('Wilma', 'Rapp', 'wilma.rapp@example.com', '+4670001066', '$2b$10$IfWeoCfH8xQ44CMw8G3XSOHCLSJoPGNErugrLB320FW7JuB1GMuTa', '2025-01-03 13:15:17', 3, 1),
    -- Original password: pass7387
    ('Viktor', 'Davidsson', 'viktor.davidsson@example.com', '+4670001067', '$2b$10$oYMGiXvJvZIJ9GboRP/f9On5rXP7FJ0DZIdBr42pk.e6O42T77H8q', '2025-06-01 22:40:45', 3, 1),
    -- Original password: pass9407
    ('Ella', 'Jönsson', 'ella.jonsson@example.com', '+4670001068', '$2b$10$0dL5h8frqT59ND/L/CO32OcNNLyXrpVH86cuGOTKbcXgi3zgYodP.', '2024-11-09 06:55:20', 2, 0),
    -- Original password: pass1428
    ('Axel', 'Sandin', 'axel.sandin@example.com', '+4670001069', '$2b$10$iqYCX516W0j5d8zTQjwIMOh9P7Pg5ShLEEB.w7z7BHwLN1GpkdpNe', '2025-05-17 14:40:54', 3, 1),
    -- Original password: pass3448
    ('Saga', 'Fransson', 'saga.fransson@example.com', '+4670001070', '$2b$10$/4K/0.0RkNk4SXSZKZWCce7r31VA5KN2dDooeb61J1PZBjz7BxqzS', '2025-03-28 12:12:30', 3, 1),
    -- Original password: pass5468
    ('Leo', 'Eklund', 'leo.eklund@example.com', '+4670001071', '$2b$10$aWn.ZHDP5fIIvQwCYrad.uaTkdLM6Jketof23LkSOrrM5ulseaW6u', '2024-10-20 09:35:40', 3, 0),
    -- Original password: pass7489
    ('Wilma', 'Lundberg', 'wilma.lundberg@example.com', '+4670001072', '$2b$10$CyKossTIiTbI1e8/OJW33.n3TGyARUEMEc5f08ABm4OqmIe36j8x6', '2025-02-18 18:42:53', 3, 1),
    -- Original password: pass9509
    ('Alma', 'Carlsson', 'alma.carlsson@example.com', '+4670001073', '$2b$10$L5Nzewk1A.GCN9XhaVHl.u5gaah9BAWVVHo6uwGc.Lj.Tq1HoTywO', '2025-04-21 23:55:15', 3, 1),
    -- Original password: pass1520
    ('Albin', 'Nyström', 'albin.nystrom@example.com', '+4670001074', '$2b$10$J7nPV5h1tqZlBUzzf025/euZRMteBAcpZ7CYe4nsiU2XXDfj4hirG', '2024-11-25 13:25:07', 1, 1),
    -- Original password: pass3540
    ('Maja', 'Augustsson', 'maja.augustsson@example.com', '+4670001075', '$2b$10$pqM0yrzG/gTVjKlC8fW4ku.2eyzyIuS1r2aiZ2ZB6Kv9xEaKWtLXO', '2025-01-13 08:45:29', 3, 1),
    -- Original password: pass5560
    ('Leo', 'Gustafsson', 'leo.gustafsson@example.com', '+4670001076', '$2b$10$Gf3Lghadl8Kt/nBgWvquxOEMbyNGuYjK6MlBXO7p2ndzPbKJbQfai', '2025-05-05 11:30:52', 2, 1),
    -- Original password: pass7580
    ('Freja', 'Holm', 'freja.holm@example.com', '+4670001077', '$2b$10$ogV3KydeEtTVOQ9nGiz7X.jAtLM.R9Om2DYHt8L/p3OZ13f0kYgGu', '2024-12-30 15:15:40', 3, 0),
    -- Original password: pass9601
    ('Viktor', 'Björk', 'viktor.bjork@example.com', '+4670001078', '$2b$10$sjSQciAFSwKZNBC/9pdHN.t/Q3EpGJmd9dFh3ESTXXE8Kt57dsHQG', '2024-10-19 10:10:10', 3, 1),
    -- Original password: pass1621
    ('Ella', 'Olsson', 'ella.olsson@example.com', '+4670001079', '$2b$10$1mGIZk/tNgQKlBfdyLR6XeC6JsUxg3gWSuTy4IgueIsLngofM.TgC', '2025-06-02 20:05:30', 3, 1),
    -- Original password: pass3641
    ('William', 'Larsson', 'william.larsson2@example.com', '+4670001080', '$2b$10$ySWA6yKjgKI9InizyHGnv.bkKK6nO7vvuiDxIGjR81z.VErJA4owC', '2025-03-14 07:15:47', 3, 0),
    -- Original password: pass5661
    ('Alva', 'Berg', 'alva.berg@example.com', '+4670001081', '$2b$10$CTPLUYSadg3PbQGSppmbSe4.K9MqFzhG5zLR.SoaIbtP6bP/v5dsq', '2025-02-21 16:40:17', 3, 1),
    -- Original password: pass7681
    ('Axel', 'Karlsson', 'axel.karlsson@example.com', '+4670001082', '$2b$10$tkzqlE22Zw7R/mz59RKmyuqUewXn0dCdkZE8U9.UvsGrvl7K0thsi', '2025-04-15 12:33:29', 1, 1),
    -- Original password: pass9701
    ('Saga', 'Lindgren', 'saga.lindgren@example.com', '+4670001083', '$2b$10$YVOfON7xH/S6AmessFDwueT6T5PK.JxRIsUU..jmIaGshl0UhdEb.', '2025-03-06 09:25:11', 3, 0),
    -- Original password: pass1722
    ('Felix', 'Engström', 'felix.engstrom@example.com', '+4670001084', '$2b$10$/306fcjNimLGcswYAQACiOqj3NCIwZjA24aV.9C06s/LTVOFI60S6', '2024-11-28 10:45:23', 3, 1),
    -- Original password: pass3742
    ('Elsa', 'Nyström', 'elsa.nystrom@example.com', '+4670001085', '$2b$10$ab/.Yo/FGeaadkTM7A7hBO3uNlUiIw2FUrN.StozKhkx/3JF56Ypq', '2025-05-26 19:30:08', 3, 1),
    -- Original password: pass5762
    ('Noah', 'Ström', 'noah.strom@example.com', '+4670001086', '$2b$10$Pu8tobpTi.CC3GnlEgDwauiRjPz4R2Rgn6QplVkp0FSBVOF0sS/PG', '2024-10-30 21:12:44', 3, 1),
    -- Original password: pass7783
    ('Moa', 'Lindqvist', 'moa.lindqvist@example.com', '+4670001087', '$2b$10$mkyBKKyz2wHxPO3PMFs12OeE5m/KdtJYqf.Lsoze4tsUGqjWy6eSC', '2025-01-14 11:05:37', 2, 0),
    -- Original password: pass9803
    ('William', 'Jansson', 'william.jansson@example.com', '+4670001088', '$2b$10$8apfs.NAk9i4.iwRNTzBGu0X.bHMCcwYZ3E9gGA19NTGZm0/Mptdm', '2025-06-01 18:20:30', 3, 1),
    -- Original password: pass1824
    ('Ella', 'Hansson', 'ella.hansson@example.com', '+4670001089', '$2b$10$fVGc.ZebPP55d3SE8Ci.AuPtiB76KwJeriNXSBRh2/VOoihSwHjJm', '2025-03-18 13:45:15', 3, 1),
    -- Original password: pass3844
    ('Leo', 'Forsberg', 'leo.forsberg@example.com', '+4670001090', '$2b$10$7qy1/fD9.9hmtJpM9B7FBud48VktzGz9Ql3eYEPcY8N3jomK63EYG', '2025-02-02 16:10:58', 3, 0),
    -- Original password: pass5864
    ('Alma', 'Svensson', 'alma.svensson@example.com', '+4670001091', '$2b$10$QdSknoydA06gIay2fhlftuzr8fSY8PVH1dEpQ0m6I3fee.mf9Cpde', '2024-12-15 08:30:24', 3, 1),
    -- Original password: pass7885
    ('Axel', 'Fredriksson', 'axel.fredriksson@example.com', '+4670001092', '$2b$10$kaWcgVXoNI/UmeNReTTNEObycpQ9Is.2U/55ut6CxmZmuxg8Q3GaS', '2025-04-09 14:15:35', 3, 1),
    -- Original password: pass9905
    ('Saga', 'Åberg', 'saga.aberg@example.com', '+4670001093', '$2b$10$3Qc8Z3A6KY1yvsHJvrG8BOyuiiEWiP2.lVq7H/NrD21ehlgJ1uIz.', '2024-11-22 19:10:10', 3, 1),
    -- Original password: pass1926
    ('Albin', 'Lundgren', 'albin.lundgren@example.com', '+4670001094', '$2b$10$9qKvX8YkdJhgd2g0R2MHA.Jm7h8s7.cpMVpvjsKgR968i3TH2lezW', '2024-10-18 20:45:42', 1, 0),
    -- Original password: pass3946
    ('Freja', 'Nilsson', 'freja.nilsson@example.com', '+4670001095', '$2b$10$fRNrwgiIrUqRIAA53iwkLu2qtPjiFM8SWq0yISplqfeXnTEuuqsdW', '2025-06-04 10:35:29', 3, 1),
    -- Original password: pass5966
    ('Isak', 'Holm', 'isak.holm@example.com', '+4670001096', '$2b$10$QaZaWBHQ6VNhsBJllw108uuxwJ7TL5Vrud.ePSeLnZKTcGy6PYKou', '2025-01-28 15:50:48', 3, 1),
    -- Original password: pass7987
    ('Wilma', 'Åström', 'wilma.astrom@example.com', '+4670001097', '$2b$10$wrgqr8rEY2RFIkklXZPSOu99hWM2sPMK39k1W5ZTQlOjn/blx3wqe', '2024-12-12 13:25:20', 3, 1),
    -- Original password: pass9007
    ('Viktor', 'Jönsson', 'viktor.jonsson@example.com', '+4670001098', '$2b$10$e5AZ/kCFpbXnlmDq8mQt9uQHjAzxP1JNjXNzC7L.GUbWGPcg6Q2QO', '2025-05-10 17:40:53', 3, 0),
    -- Original password: pass1028
    ('Ella', 'Lind', 'ella.lind@example.com', '+4670001099', '$2b$10$izUy5jFmG6w/FkduFbWdAur4gcQRavvtan/kgeZ6lGGNZarczP4YW', '2025-03-02 19:55:05', 2, 1),
    -- Original password: pass3048
    ('Lucas', 'Bergström', 'lucas.bergstrom@example.com', '+4670001100', '$2b$10$JKfhKxqVyjmFJgxSISGaJO9wzU3g5NIVrVBn/9ZWERE.CHesZtZKq', '2025-04-17 09:40:38', 3, 1);
