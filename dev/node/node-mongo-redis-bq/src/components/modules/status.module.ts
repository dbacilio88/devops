import { Module } from "@nestjs/common";
import { TypeOrmModule } from '@nestjs/typeorm';
import { ContextInformationUtil } from "../utils/context.information.util";
import { BusinessResponse } from "src/dtos/response/businnes.response";
import { StatusDocument } from "src/api/documents/status.document";
import { StatusRepository } from "src/api/documents/contracts/status.repository";
import { StatusMapper } from "../mappers/status.mapper";
import { StatusProfile } from "../mappers/status.profile";

@Module({
    imports: [
        TypeOrmModule.forFeature([StatusDocument])
    ],
    controllers: [],
    providers: [StatusRepository, StatusMapper, StatusProfile, ContextInformationUtil, BusinessResponse]
})
export class StatusModule { }