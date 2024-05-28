import { Module } from "@nestjs/common";
import { TypeOrmModule } from '@nestjs/typeorm';
import { SpecialtyMapper, SpecialtyProfile } from "../mappers/index.mapper";
import { ContextInformationUtil } from "../utils/context.information.util";
import { BusinessResponse } from "src/dtos/response/businnes.response";
import { SpecialtyDocument } from "src/api/documents/Specialty.document";
import { SpecialtyController } from "src/api/controllers/Specialty.controller";
import { SpecialtyService } from "src/api/services/Specialty.service";
import { SpecialtyRepository } from "src/api/documents/contracts/Specialty.repository";

@Module({
    imports: [
        TypeOrmModule.forFeature([SpecialtyDocument])
    ],
    controllers: [SpecialtyController],
    providers: [SpecialtyService, SpecialtyMapper, SpecialtyProfile, SpecialtyRepository, ContextInformationUtil, BusinessResponse]
})
export class SpecialtyModule { }